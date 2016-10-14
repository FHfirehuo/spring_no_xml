package com.eiecc.fire.spring_4_no_xml.prepost;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JSR250WayService {

	@PostConstruct //在构造函数之前执行
	public void init() {
		System.out.println("jsr250-init—method");

	}

	public JSR250WayService() {
		super();
		System.out.println("初始化构造函数-JSR250WayService");
	}
	
	@PreDestroy //在bean销毁之前执行 //被销毁是指垃圾回收时//垃圾回收可能比AnnotationConfigApplicationContext关闭晚//运行此主函数看日志可知
	public void destory(){
		System.out.println("jsr250-destory—method");
	}
}
