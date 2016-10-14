package com.eiecc.fire.spring_4_no_xml.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoListener implements ApplicationListener<DemoEvent> { //实现ApplicationListener接口，并指定监听的事件类型

	@Override
	public void onApplicationEvent(DemoEvent demoEvent) { //使用onApplicationEvent方法对消息进行处理
		System.out.println("++++++");
		String msg = demoEvent.getMsg();
		System.out.println("我（bean-demoListener）接收到bean-demopublisher发布的消息："+msg);
		
	}

}
