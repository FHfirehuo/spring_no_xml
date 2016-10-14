package com.eiecc.fire.spring_4_no_xml.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.eiecc.fire.spring_4_no_xml.config")
@PropertySource("classpath:settings.properties")
public class OnWebStartConfig {
	
	@Value("${app.ctx}")
	private String ctx;

	@Bean //使用注解声明当前方法返回值是一个bean，bean的名称是方法名
	public ConfigFactory configFactory(){
		return new ConfigFactory(ctx);
		
	}
	
	
}
