package jp.paulownia.sample.websocket;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.eclipse.jetty.server.Server;

public class JettyFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton jButton0;

	public JettyFrame() {
		initComponents();
	}

	private Server server;
	public JettyFrame(Server server) {
		this();
		this.server = server;
	}

	private void initComponents() {
		add(getJButton0());
		setSize(320, 63);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				stopServer();
			}
		});
	}

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("サーバを停止");
			jButton0.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent event) {
					stopServer();
				}
			});
		}
		return jButton0;
	}




	private void stopServer() {
		if (server != null) {
			try {
				server.stop();
				server.destroy();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
