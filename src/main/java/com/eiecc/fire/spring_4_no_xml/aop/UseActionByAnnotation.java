package com.eiecc.fire.spring_4_no_xml.aop;

import org.springframework.stereotype.Service;

@Service
public class UseActionByAnnotation {
	
	@Action(name="注解式拦截的add操作")
	public void add() {
		
	}

}
