package com.rummycircle.wsclient;

import java.net.URI;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;

public class ClientClass {

	public Socket socketObject;
	private org.eclipse.jetty.websocket.client.WebSocketClient client;
	private Session session;
	private Queue<String> messages;
	private URI uri;
	private static Logger LOG = Logger.getLogger(ClientClass.class.getName());

	public ClientClass() {
		PropertyConfigurator.configure("log4j.properties");
		this.messages = new LinkedList<String>();
		this.client = new org.eclipse.jetty.websocket.client.WebSocketClient(
				new SslContextFactory(true));
		this.socketObject = new Socket(messages);
		this.client.getPolicy().setMaxTextMessageSize(Integer.MAX_VALUE);
		this.client.getPolicy().setMaxBinaryMessageSize(Integer.MAX_VALUE);
	}

	public Queue<String> getMessages() {
		return messages;
	}

	public void setMessageSize(int messageSize) {
		if (messageSize > 0) {
			this.client.getPolicy().setMaxTextMessageSize(messageSize);
			this.client.getPolicy().setMaxBinaryMessageSize(messageSize);
		}
	}

	/**
	 * This method tells what processing the message need to be dealt with.
	 * 
	 * @param handler
	 */
	public void addMessageHandler(MessageHandler handler) {
		socketObject.addMessageHandler(handler);
	}
	/**
	 * The methods initializes the webSocket client and create a webSocket
	 * session for the given URL.
	 * 
	 * @param url
	 * @throws Exception
	 */
	public void start(String url) throws Exception {
		if (!isValid(url)) {
			LOG.error("Invalid URL given! " + url);
			return;
		}
		client.start();
		if (session == null || !session.isOpen()) {
			this.uri = URI.create(url);
			session = client.connect(socketObject, uri).get();
			LOG.info("Connected to " + session.getRemoteAddress().getAddress());
		} else {
			LOG.error("Session is "
					+ (session == null ? "null"
							: (session.isOpen() ? " open already for uri "
									+ uri : "NA")));
		}
	}

	public void start(String url, ClientUpgradeRequest updateRequest)
			throws Exception {
		if (!isValid(url)) {
			LOG.error("Invalid URL given! " + url);
			return;
		}
		
		client.start();
		if (session == null || !session.isOpen()) {
			this.uri = URI.create(url);
			session = updateRequest == null ? client.connect(socketObject, uri)
					.get() : client.connect(socketObject, uri, updateRequest)
					.get();
			LOG.info("Connected to : "
					+ session.getRemoteAddress().getAddress());
		} else {
			LOG.error("Session is "
					+ (session == null ? "null"
							: (session.isOpen() ? " open already for uri "
									+ uri : "NA")));
		}
	}

	/**
	 * This method is to check whether the session is open/closed
	 * 
	 * @return
	 */
	public boolean isConnected() {
		return session != null && session.isOpen();
	}

	/**
	 * This method is to check whether the input url is valid or not
	 * 
	 * @param url
	 * @return
	 */
	private boolean isValid(String url) {
		if (url == null || url.trim().isEmpty()) {
			return false;
		}
		if (url.startsWith("ws://") || url.startsWith("wss://")) {
			return true;
		}
		return false;
	}

	/**
	 * This method is to send message to the web socket server
	 * 
	 * @param message
	 * @throws Exception
	 */
	public void sendMessage(String message) throws Exception {
		if (session != null && session.isOpen()) {
			messages.clear();
			
			if(!message.contains("heartbeat"))
				LOG.info("Sending Message: " + message);
			
			session.getRemote().sendString(message);
		} else {
			LOG.error("Session not created");
		}
	}

	/**
	 * This method is to send message to the web socket server
	 * 
	 * @param message
	 * @throws Exception
	 */
	public void sendMessage(byte[] message) throws Exception {
		if (session != null && session.isOpen()) {
			messages.clear();
			session.getRemote().sendBytes(ByteBuffer.wrap(message));
		} else {
			LOG.error("Session not created");
		}
	}

	public void close() throws Exception {
		closeSession();
		closeClient();
	}

	public void closeClient() throws Exception {
		client.stop();
		client.destroy();
	}

	public void closeSession() {
		if (session != null && session.isOpen()) {
			session.close();
		}
	}

	public void sleep(long seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
