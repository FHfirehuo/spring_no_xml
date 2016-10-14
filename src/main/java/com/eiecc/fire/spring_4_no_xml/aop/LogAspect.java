package com.eiecc.fire.spring_4_no_xml.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/***
 * 编写切面
 * @author fire
 *
 */

@Aspect //注解声明是一个切面
@Component //让切面成为spring管理的bean
public class LogAspect {
	
	///Main 测试开始
	
	@Pointcut("@annotation(com.eiecc.fire.spring_4_no_xml.aop.Action)") //声明切点
	public void annotationPointCut() {
		
		
	}
	
	@After("annotationPointCut()")  //声明一个建言，并使用@Pointcut定义的切点
	private void after(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);
		System.out.println("注解式拦截:"+action.name());  //通过反射获取注解的属性，然后做日志记录相关的操作，下面的相同
	}
	
	@Before("execution(* com.eiecc.fire.spring_4_no_xml.aop.UseActionByMethod.*(..))") //声明一个建言，此建言直接使用拦截规则作为参数 ///注意第一个*后有一个空格
	private void before(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();

		System.out.println("方法股则式拦截:"+method.getName());

	}
	///Main 测试结束
	
	
	/*****************************下面是web的用法**************************************/
	@Pointcut("@annotation(com.eiecc.fire.spring_4_no_xml.aop.Authority)") //声明切点
	public void authorityPointCut() {
		
		
	}
	
	@Before("authorityPointCut()")  //声明一个建言，并使用@Pointcut定义的切点
	private void beforeAdd(JoinPoint joinPoint) throws Exception {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Authority authority = method.getAnnotation(Authority.class);
		String authorityName= authority.name();
		System.out.println(authorityName+"权限不足！");
		throw new Exception("权限不足");
	}

}
