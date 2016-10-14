package com.eiecc.fire.spring_4_no_xml.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 * 编写注解规则
 * @author fire
 *注解本身没有功能，就和xml一样，是一种元数据
 *元数据即解释数据的数据，这就是所谓的配置
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
	String name();
}
