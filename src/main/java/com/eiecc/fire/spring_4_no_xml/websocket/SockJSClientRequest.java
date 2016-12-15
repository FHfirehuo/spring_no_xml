package com.eiecc.fire.spring_4_no_xml.websocket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;


/***
 * The example below shows how to create a SockJS client and connect to a SockJS
 * endpoint:
 * 
 * @author fire
 *
 *
 *         提供SockJS
 *         Java客户端以便在不使用浏览器的情况下连接到远程SockJS端点。当需要通过公共网络在两个服务器之间进行双向通信时，这是特别有用的，即，
 *         其中网络代理可以排除使用WebSocket协议。 SockJS Java客户端对于测试也非常有用，例如模拟大量的并发用户。
 * 
 *         SockJS Java客户端支持“websocket”，“xhr-streaming”和“xhr-polling”传输。
 *         其余的只有在浏览器中使用才有意义。
 * 
 *         WebSocketTransport可以配置为：
 * 
 *         JSR-356运行时中的StandardWebSocketClient JettyWebSocketClient使用Jetty
 *         9+本机WebSocket API 任何实现Spring的WebSocketClient
 *         XhrTransport定义支持“xhr-streaming”和“xhr-polling”，因为从客户端的角度来看，
 *         除了用于连接到服务器的URL之外没有区别。目前有两种实现：
 * 
 *         RestTemplateXhrTransport使用Spring的RestTemplate来处理HTTP请求。
 *         JettyXhrTransport使用Jetty的HttpClient进行HTTP请求。
 */
public class SockJSClientRequest{

	public void a() {
		List<Transport> transports = new ArrayList<Transport>(2);
		transports.add(new WebSocketTransport(new StandardWebSocketClient()));
		transports.add(new RestTemplateXhrTransport());

		SockJsClient sockJsClient = new SockJsClient(transports);
		sockJsClient.doHandshake(webSocketHandler(), "ws://example.com:8080/sockjs"); //new MyWebSocketHandler(), "ws://example.com:8080/sockjs"
	}

	@Bean
	public WebSocketHandler webSocketHandler() {
		return new MyHandler();
	}

	public void jettyHttpClientToShow() {
		//HttpClient jettyHttpClient = new HttpClient();
		// jettyHttpClient.setMaxConnectionsPerDestination(1000);
		// jettyHttpClient.setExecutor(new QueuedThreadPool(1000));
	}

}
