package com.eiecc.fire.spring_4_no_xml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.eiecc.fire.spring_4_no_xml.config.ConfigFactory;
import com.eiecc.fire.spring_4_no_xml.interceptor.RequestTimeInterceptor;

/***
 * 不提供web服务支持，现在仅提供参考，最终配置请看mvc下
 * 
 * @author fire
 *
 */
@Configuration // 声明当前类是一个配置类，相当于一个spring配置的xml文件，这意味着这个类里可以有0个或者多个@Bean注解
@EnableWebMvc // 开启springmvc支持。若无此句，重写WebMvcConfigurerAdapter方法无效
@ComponentScan // ("com.eiecc.fire.spring_4_no_xml") //若不加（）则必须保证本类在最外层
				// //自动扫描包名下所有使用@service、@component、@repository和@controller的类，并注册为bean
public class WebConfig extends WebMvcConfigurerAdapter { // 重写其方法可对springmvc进行配置

	@Bean // 使用注解声明当前方法返回值是一个bean，bean的名称是方法名
	public ConfigFactory configFactory() {
		return new ConfigFactory();

	}

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
