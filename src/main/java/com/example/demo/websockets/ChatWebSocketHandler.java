package com.example.demo.websockets;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class ChatWebSocketHandler extends TextWebSocketHandler{

	private final Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<>());
	
  @Override
  public void afterConnectionEstablished(WebSocketSession session) {
      sessions.add(session);
      System.out.println("New client connected: " + session.getId());
  }
  
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	    String payload = message.getPayload();
	    System.out.println("Received: " + payload);
	
	    // Broadcast message to all connected clients
	    synchronized (sessions) {
	        for (WebSocketSession s : sessions) {
	            if (s.isOpen()) {
	                s.sendMessage(new TextMessage(payload));
	            }
	        }
	    }
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, org.springframework.web.socket.CloseStatus status) {
	    sessions.remove(session);
	    System.out.println("Client disconnected: " + session.getId());
	}
}
