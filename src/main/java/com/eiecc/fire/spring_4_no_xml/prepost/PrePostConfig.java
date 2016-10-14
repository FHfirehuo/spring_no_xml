package com.eiecc.fire.spring_4_no_xml.prepost;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class PrePostConfig {

	@Bean(initMethod="init",destroyMethod="destory")
	BeanWayService beanWayService(){
		return new BeanWayService();
		
	}
	
	@Bean
	JSR250WayService jsr250WayService(){
		return new JSR250WayService();
		
	}
}
