package com.forrest.websocket.server;

import java.io.IOException;
import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

public class Main {
	private static String uri = "ws://127.0.0.1:8086/socketServer/forrest07";
	private static Session session;

	public void start() {
		WebSocketContainer container = null;
		try {
			container = ContainerProvider.getWebSocketContainer();
		} catch (Exception ex) {
			System.out.println("error" + ex);
		}
		try {
			URI r = URI.create(uri);
			session = container.connectToServer(SocketServer.class, r);
		} catch (DeploymentException | IOException e) {
			e.printStackTrace();
		}
	}
}
