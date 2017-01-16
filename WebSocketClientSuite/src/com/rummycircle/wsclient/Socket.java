package com.rummycircle.wsclient;

import java.util.Properties;
import java.util.Queue;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;


public @WebSocket class Socket {

	private Queue<String> messages;
	public MessageHandler handler;
	private static Logger LOG = Logger.getLogger(Socket.class.getName());
	
	public Socket(Queue<String> messages) {
		PropertyConfigurator.configure("log4j.properties");
		this.messages = messages;
	}

	@OnWebSocketConnect
	public void onConnect(Session session) {
		//LOG.info("onConnect(): " + session);
	}

	public void addMessageHandler(MessageHandler handler) {
		this.handler = handler;
	}

	@OnWebSocketClose
	public void onClose(int statusCode, String reason) {
		LOG.info("onClose() - statusCode: " + statusCode + " & reason: " + reason);
	}

	@OnWebSocketError
	public void onError(Throwable cause) {
		LOG.warn(cause);
	}

	@OnWebSocketMessage
	public void onMessage(String msg) {
		messages.add(msg);
		if (handler != null) {
			handler.handleMessage(msg);
		}
		//LOG.info("onMessage() - " + msg);
	}
}