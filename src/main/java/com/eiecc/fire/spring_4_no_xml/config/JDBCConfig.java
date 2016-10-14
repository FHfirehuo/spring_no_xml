package com.eiecc.fire.spring_4_no_xml.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@ComponentScan("com.eiecc.fire.spring_4_no_xml.dao")
public class JDBCConfig {
	
	@Bean
	public DruidDataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver"); // 这个不能少,也别写错，，，错了还不报错！
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_no_xml");
		dataSource.setUsername("root");
		dataSource.setPassword("OpenFire%@61");
		
		/*dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_jpa");
		dataSource.setUsername("tutorialuser");
		dataSource.setPassword("tutorialmy5ql");*/
		
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		
		return jdbcTemplate;
	}

}
