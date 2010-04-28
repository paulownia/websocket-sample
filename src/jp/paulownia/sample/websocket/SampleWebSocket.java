package jp.paulownia.sample.websocket;

import java.io.IOException;

import org.eclipse.jetty.websocket.WebSocket;

public class SampleWebSocket implements WebSocket, MessageListener {

	private Outbound outbound;

	public SampleWebSocket() {
		super();
	}

	@Override
	public void onConnect(Outbound outbound) {
		System.out.println("connected.");
		this.outbound = outbound;
		MessageSubject.getInstance().addListener(this);
	}

	@Override
	public void onDisconnect() {
		System.out.println("disconnected.");
		MessageSubject.getInstance().removeListener(this);
	}

	@Override
	public void onMessage(byte frame, String data) {
		MessageSubject.getInstance().update(data);
	}

	@Override
	public void onMessage(byte frame, byte[] data, int offset, int length) {
		// do nothing..
	}

	@Override
	public void onReceive(String message) {
		try {
			this.outbound.sendMessage(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
