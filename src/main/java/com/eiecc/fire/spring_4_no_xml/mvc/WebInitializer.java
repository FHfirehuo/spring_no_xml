package com.eiecc.fire.spring_4_no_xml.mvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.eiecc.fire.spring_4_no_xml.mvc.config.JpaConfig;
import com.eiecc.fire.spring_4_no_xml.mvc.config.WebSocketConfig;
import com.eiecc.fire.spring_4_no_xml.mvc.web.MvcConfig;

/***
 * 
 * @author fire
 *
 */
public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();

		webApplicationContext.register(MvcConfig.class, WebSocketConfig.class, JpaConfig.class);
		webApplicationContext.setServletContext(servletContext);

		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(webApplicationContext));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		servlet.setAsyncSupported(true); // 开启异步支持

	}

}
