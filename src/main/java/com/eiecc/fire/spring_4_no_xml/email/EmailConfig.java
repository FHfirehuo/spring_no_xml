package com.eiecc.fire.spring_4_no_xml.email;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan
public class EmailConfig {

	@Bean
	public JavaMailSenderImpl mailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.sina.com");
		mailSender.setProtocol("smtp");
		mailSender.setPort(25);
		mailSender.setUsername("liu511374191@sina.com");
		mailSender.setPassword("xiaoyaomeng");
		Properties javaMailProperties = new Properties();

		/*javaMailProperties.setProperty("mail.transport.protocol", "smtp");
		javaMailProperties.setProperty("mail.smtp.auth", "true");
		javaMailProperties.setProperty("mail.smtp.starttls.enable", "false");
		javaMailProperties.setProperty("mail.debug", "true");
		mailSender.setJavaMailProperties(javaMailProperties);*/
		return mailSender;

	}

	@Bean
	public SimpleMailMessage templateMessage() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("liu511374191@sina.com");
		message.setSubject("Your order");
		return message;

	}

}
