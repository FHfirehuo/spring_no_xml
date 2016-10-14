package com.eiecc.fire.spring_4_no_xml.el;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/***
 * 说明
 * @author fire
 * @1 
 * 无论使用@Value还是使用Environment
 * 注入文件都需要使用@PropertySource指定文件地址，
 * 若使用@Value注入，则需要配置一个PropertySourcesPlaceholderConfigurer的bean。/////亲测这个不需要
 * 注意，@Value("${book.name}")使用的是$而不是#
 */
@Configuration
@ComponentScan("com.eiecc.fire.spring_4_no_xml.el.service")
@PropertySource("classpath:com/eiecc/fire/spring_4_no_xml/el/test.properties")// @1
public class ELConfig {

	@Value("I Love You")
	private String normal;
	
	@Value("#{systemProperties['os.name']}")
	private String osName;
	
	
	@Value("#{ T(java.lang.Math).random() * 100.0 }")
	private double randomNumber;
	
	/*@Value("#{demoService.another}")
	private double fromAnother;*/  ///然而并不是这样的报错啊
	
	
	@Value("classpath:com/eiecc/fire/spring_4_no_xml/el/test.txt")  //地址必须准确，否则报错
	private Resource testFile;
	
	@Value("http://www.baidu.com")
	private Resource testUrl;   //获取的是网址的所有内容
	
	@Value("${book.name}") // @1
	private String bookName;
	
	@Autowired
	private Environment environment;//@1
	
	/*@Bean //@1
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
		
	}*/
	
	
	public void outputResource() {
		
		try {
			System.out.println(normal);
			System.out.println(osName);
			System.out.println(randomNumber);
			////System.out.println(fromAnother); ///错误的一种获取方式
			
			//System.out.println(IOUtils.toString(testFile.getInputStream()));
			System.out.println(IOUtils.toString(testFile.getInputStream(), "UTF-8"));
			//System.out.println(IOUtils.toString(testUrl.getURI()));
			//System.out.println(IOUtils.toString(testUrl.getURI(), "UTF-8"));
			System.out.println(bookName); //@1
			System.out.println(environment.getProperty("book.author")); //@1
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
