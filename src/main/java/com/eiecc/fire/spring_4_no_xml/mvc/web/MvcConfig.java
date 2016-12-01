package com.eiecc.fire.spring_4_no_xml.mvc.web;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.eiecc.fire.spring_4_no_xml.interceptor.RequestTimeInterceptor;
import com.eiecc.fire.spring_4_no_xml.mvc.messageconverter.MyMessageConverter;

@Configuration
@EnableWebMvc
@ComponentScan("com.eiecc.fire.spring_4_no_xml.mvc")
public class MvcConfig extends WebMvcConfigurerAdapter {

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

	/***
	 * 重写此方法可以不忽视路径参数中带"."后面的值
	 * 
	 * @see http://localhost:8080/spring_4_no_xml/rest/getjson.do
	 */
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {

		configurer.setUseSuffixPatternMatch(false);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		registry.addViewController("/converter").setViewName("converter");
		registry.addViewController("/sse").setViewName("sse");
	}

	/***
	 * 配置HttpMessageConverter可重载下面两个方法任意一个
	 * 
	 * configureMessageConverters:重载会覆盖掉spring mvc默认注册的多个HttpMessageConverter
	 * extendMessageConverters:仅添加一个自定义的HttpMessageConverter,
	 * 不覆盖默认注册的HttpMessageConverter
	 * 
	 * @param converters
	 */
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(converter());
	}

	@Bean
	public MyMessageConverter converter() {

		return new MyMessageConverter();
	}

}
