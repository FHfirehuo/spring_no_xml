package com.eiecc.fire.spring_4_no_xml.mvc.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

/*Spring框架通过spring-messaging和spring-websocket模块提供了对通过WebSocket使用STOMP的支持。
 * 下面是一个在URL路径/文件夹中显示STOMP WebSocket / SockJS端点的示例，
 * 其中目的地以“/ app”开头的邮件路由到邮件处理方法（即应用程序工作）和目标以“/ topic” 或“/ queue”将被路由到消息代理（即广播到其他连接的客户端）：
*/
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{ //implements WebSocketMessageBrokerConfigurer ex

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {

		registry.addEndpoint("/portfolio").withSockJS();
	}

	/*
	 * “/app”前缀是任意的。您可以选择任何前缀。这只是意味着区分消息路由到消息处理方法来做应用程序工作vs消息路由到代理广播到订阅的客户端。“/
	 * topic”和“/queue”前缀取决于正在使用的代理。在简单的内存代理的情况下，前缀没有任何特殊意义;它只是一个指示如何使用目的地的约定（pub
	 * -sub针对许多订户或点对点消息，通常针对单个收件人）。在使用专用代理的情况下，大多数代理使用“/topic”作为具有pub-
	 * sub语义的目的地的前缀，并且对于具有点到点语义的目的地使用“/queue”。检查代理的STOMP页面以查看它支持的目标语义。
	 */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {

		registry.setApplicationDestinationPrefixes("/app");
		registry.enableSimpleBroker("/topic", "/queue");
	}



}
