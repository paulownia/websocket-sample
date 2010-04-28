package jp.paulownia.sample.websocket;


import javax.swing.JFrame;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


/**
 * Jettyサーバの起動
 */
public class Main {
	public static void main(String[] args) {
		Server server = new Server(8080);
		HandlerList handlerList = new HandlerList();

		// HTMLファイル
		ResourceHandler resourceHandler = new ResourceHandler();
		resourceHandler.setWelcomeFiles(new String[]{ "index.html" });
		resourceHandler.setResourceBase("./html");
		handlerList.addHandler(resourceHandler);

		// WebSocketサーブレット
		ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		servletContextHandler.addServlet(new ServletHolder(new SampleWebSocketServlet()), "/socket");
		handlerList.addHandler(servletContextHandler);


		server.setHandler(handlerList);

		JFrame frame = new JettyFrame(server);
		frame.setVisible(true);

		try {
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		frame.dispose();
	}
}
