package com.eiecc.fire.spring_4_no_xml;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.eiecc.fire.spring_4_no_xml.aop.AopConfig;
import com.eiecc.fire.spring_4_no_xml.config.ConfigFactory;
import com.eiecc.fire.spring_4_no_xml.config.JPAConfig;
import com.eiecc.fire.spring_4_no_xml.config.OnWebStartConfig;
import com.eiecc.fire.spring_4_no_xml.profile.DemoBean;
import com.eiecc.fire.spring_4_no_xml.profile.ProfileConfig;

/***
 * 
 * @author fire
 *
 */
public class WebInitializer { //implements WebApplicationInitializer


	public void onStartup(ServletContext servletContext) throws ServletException {
		
		///这种是可以得
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(OnWebStartConfig.class);
		ConfigFactory config = context.getBean(ConfigFactory.class); 
		config.SayHello();
		String ctx = config.getCtx();
		context.close();
		
		servletContext.setInitParameter("spring.profiles.default", "prod"); //Servlet3.0及以上，低于本版本的用xml的配置方式配置spring.profiles.active
		
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		System.out.println("ctx:"+ctx);
		//servletContext.setAttribute("ctx", servletContext.getContextPath());
		servletContext.setAttribute("ctx", ctx);
		webApplicationContext.register(WebConfig.class, JPAConfig.class); //AopConfig.class, ProfileConfig.class,
		webApplicationContext.setServletContext(servletContext);
		
		/***
		 * //感觉没有任何意义，仅供了解
		 * ///后来发现这个不行 必须使用AnnotationConfigApplicationContext 而不是AnnotationConfigWebApplicationContext
		 * AnnotationConfigApplicationContext启动方式见aop下的main
		 */
		//ConfigFactory config = ctx.getBean(ConfigFactory.class); 
		
		/***
		 * 这种方式也是不行的
		 */
		//ConfigFactory2 configFactory2 = ctx.getBean(ConfigFactory2.class);
		//configFactory2.SayHello();
		
		/***
		 * 也不行
		 */
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
		//ConfigFactory config = context.getBean(ConfigFactory.class); 
		//config.SayHello();
		
		/***
		 * 也不行
		 */
		//ConfigFactory config = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).getBean(ConfigFactory.class);
		//config.SayHello();
		
		
		
		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(webApplicationContext));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		
	}



}
