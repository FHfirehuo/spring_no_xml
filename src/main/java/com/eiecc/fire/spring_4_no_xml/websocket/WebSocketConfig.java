package com.eiecc.fire.spring_4_no_xml.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

		registry.addHandler(myHandler(), "/myHandler").addInterceptors(new HttpSessionHandshakeInterceptor())// 自定义初始HTTP,WebSocket握手请求的最简单的方法是通过HandshakeInterceptor，它暴露“之前”和“之后”的握手方法。这样的拦截器可以用于排除握手或使任何属性可用于WebSocketSession。例如，有一个内置拦截器用于将HTTP会话属性传递到WebSocket会话：
				.withSockJS()
				.setClientLibraryUrl("http://localhost:8080/myapp/js/sockjs-client.js")//针对X-Frame-Options响应头
				;
	}

	/*
	 * 从Spring Framework
	 * 4.1.5开始，WebSocket和SockJS的默认行为是只接受相同的源请求。也可以允许所有或指定的原点列表。此检查主要是为浏览器客户端设计的。
	 * 没有什么阻止其他类型的客户端修改Origin头值（更多细节，请参阅RFC 6454：Web Origin Concept）。
	 * 
	 * 3种可能的行为是：
	 * 
	 * 仅允许相同的原始请求（默认）：在此模式下，当SockJS启用时，Iframe
	 * HTTP响应头X-Frame-Options设置为SAMEORIGIN，并且JSONP传输被禁用，因为它不允许检查请求的来源。因此，当启用此模式时
	 * ，不支持IE6和IE7。 允许指定的起点列表：每个提供的允许起点必须以http：//或https：//开头。在此模式下，当SockJS启用时，
	 * 基于IFrame和JSONP的传输都被禁用。因此，当启用此模式时，不支持IE6至IE9。
	 * 允许所有原点：要启用此模式，应提供*作为允许的原始值。在此模式下，所有传输都可用。 WebSocket和SockJS允许的起点可以配置如下所示：
	 * 
	 * @Override public void registerWebSocketHandlers(WebSocketHandlerRegistry
	 * registry) { registry.addHandler(myHandler(),
	 * "/myHandler").setAllowedOrigins("http://mydomain.com"); }
	 */

	@Bean
	public WebSocketHandler myHandler() {
		return new MyHandler();
	}

	/***
	 * 每个底层WebSocket引擎都提供了控制运行时特性的配置属性，例如消息缓冲区大小，空闲超时等。
	 * 
	 * 此配置是针对于Tomcat的
	 * 
	 * @return
	 */
	@Bean
	public ServletServerContainerFactoryBean createWebSocketContainer() {
		ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
		container.setMaxTextMessageBufferSize(8192);
		container.setMaxBinaryMessageBufferSize(8192);
		return container;
	}

	/*
	 * 此配置是针对Jetty的
	 * 
	 * @Override public void registerWebSocketHandlers(WebSocketHandlerRegistry
	 * registry) { registry.addHandler(echoWebSocketHandler(),
	 * "/echo").setHandshakeHandler(handshakeHandler()); }
	 * 
	 * @Bean public DefaultHandshakeHandler handshakeHandler() {
	 * 
	 * WebSocketPolicy policy = new WebSocketPolicy(WebSocketBehavior.SERVER);
	 * policy.setInputBufferSize(8192); policy.setIdleTimeout(600000);
	 * 
	 * return new DefaultHandshakeHandler(new JettyRequestUpgradeStrategy(new
	 * WebSocketServerFactory(policy))); }
	 */

}
