package jp.paulownia.sample.websocket;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

public class SampleWebSocketServlet extends WebSocketServlet {

	private static final long serialVersionUID = -4964922222677003986L;

	@Override
	protected WebSocket doWebSocketConnect(HttpServletRequest req, String protocol) {
		return new SampleWebSocket();			
	}

}
