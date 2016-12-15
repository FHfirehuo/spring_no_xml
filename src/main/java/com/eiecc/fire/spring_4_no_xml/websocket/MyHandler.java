package com.eiecc.fire.spring_4_no_xml.websocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/***
 * Creating a WebSocket server is as simple as implementing WebSocketHandler or
 * more likely extending either TextWebSocketHandler or BinaryWebSocketHandler
 * 
 * @author fire
 *
 */

public class MyHandler extends TextWebSocketHandler {

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		super.handleTextMessage(session, message);
	}

}
