package jp.paulownia.sample.websocket;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * メッセージ管理クラス、メッセージを受け取ったときに登録したリスナに受信イベントを発行する
 */
public class MessageSubject {

	private static MessageSubject instance = new MessageSubject();

	public static MessageSubject getInstance() {
		return instance;
	}

	private Set<MessageListener> listeners = new CopyOnWriteArraySet<MessageListener>();

	public void addListener(MessageListener listener) {
		this.listeners.add(listener);
	}

	public void removeListener(MessageListener listener) {
		this.listeners.remove(listener);
	}

	public void update(String message) {
		for (MessageListener listener: this.listeners) {
			listener.onReceive(message);
		}
	}
}
