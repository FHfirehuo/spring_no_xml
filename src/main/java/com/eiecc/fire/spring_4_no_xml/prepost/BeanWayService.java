package com.eiecc.fire.spring_4_no_xml.prepost;

public class BeanWayService {

	public void init() {
		System.out.println("@bean-init—method");

	}

	public BeanWayService() {
		super();
		System.out.println("初始化构造函数-BeanWayService");
	}
	
	public void destory(){
		System.out.println("@bean-destory—method");
	}
	
	
}
