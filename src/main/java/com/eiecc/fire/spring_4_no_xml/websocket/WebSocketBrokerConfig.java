package com.eiecc.fire.spring_4_no_xml.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurationSupport;

/***
 * 扩展AbstractMessageBrokerConfiguration并添加用于接收和响应来自WebSocket客户端的STOMP消息的配置。
 * 通常与@EnableWebSocketMessageBroker结合使用，但也可以直接扩展。
 * 
 * @author fire
 *
 */
@Configuration
public class WebSocketBrokerConfig extends WebSocketMessageBrokerConfigurationSupport {

	@Override
	protected void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/sockjs").withSockJS().setStreamBytesLimit(512 * 1024).setHttpMessageCacheSize(1000)
				.setDisconnectDelay(30 * 1000);

	}

}
