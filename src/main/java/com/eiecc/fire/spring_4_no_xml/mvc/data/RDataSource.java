package com.eiecc.fire.spring_4_no_xml.mvc.data;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import com.alibaba.druid.pool.DruidDataSource;

@Component
public class RDataSource implements FireDataSource {

	@Override
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver"); // 这个不能少,也别写错，，，错了还不报错！
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_no_xml");
		dataSource.setUsername("root");
		dataSource.setPassword("OpenFire%@61");

		dataSource.setInitialSize(1);
		dataSource.setMinIdle(1); // 默认0
		dataSource.setMaxActive(20); // 默认8
		dataSource.setMaxWait(60000);

		dataSource.setMaxPoolPreparedStatementPerConnectionSize(20); // 默认10
		return dataSource;
	}

}
