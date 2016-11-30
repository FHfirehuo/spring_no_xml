package com.eiecc.fire.spring_4_no_xml.mvc.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.eiecc.fire.spring_4_no_xml.interceptor.RequestTimeInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/classes/views/"); // 这是编译后的目录
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;

	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		// addResourceHandler对外暴露的路径 //addResourceLocations文件放置的目录
		registry.addResourceHandler("/resource/**").addResourceLocations("classpath:/resource/");
	}

	@Bean // 配置拦截器的bean
	public RequestTimeInterceptor rti() {
		return new RequestTimeInterceptor();

	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(rti());
	}

}
