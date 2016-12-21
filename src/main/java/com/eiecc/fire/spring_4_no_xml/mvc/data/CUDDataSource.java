package com.eiecc.fire.spring_4_no_xml.mvc.data;

import org.springframework.stereotype.Component;

import com.alibaba.druid.pool.DruidDataSource;

@Component
public class CUDDataSource implements FireDataSource {

	public DruidDataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver"); // 这个不能少,也别写错，，，错了还不报错！
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_no_xml");
		dataSource.setUsername("root");
		dataSource.setPassword("OpenFire%@61");
		
		/*
		 * maxIdle是Druid为了方便DBCP用户迁移而增加的，maxIdle是一个混乱的概念。
		 * 连接池只应该有maxPoolSize和minPoolSize，druid只保留了maxActive和minIdle，
		 * 分别相当于maxPoolSize和minPoolSize。
		 */
		
		/*
		 * 通常来说，只需要修改initialSize、minIdle、maxActive。
		 * 
		 * 如果用Oracle，则把poolPreparedStatements配置为true，mysql可以配置为false。分库分表较多的数据库，
		 * 建议配置为false。
		 */
		dataSource.setInitialSize(1);
		dataSource.setMinIdle(1); //默认0
		dataSource.setMaxActive(20); //默认8
		dataSource.setMaxWait(60000);
		//dataSource.setTimeBetweenEvictionRunsMillis(60000); //默认60000
		//dataSource.setMinEvictableIdleTimeMillis(300000); //最小300000
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(20); //默认10
		//dataSource.setPoolPreparedStatements(false); //默认是false
		return dataSource;
	}

	// <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource"
	// init-method="init" destroy-method="close">
	//
	// <!-- 配置初始化大小、最小、最大 -->
	// <property name="initialSize" value="1" />
	// <property name="minIdle" value="1" />
	// <property name="maxActive" value="20" />
	//
	// <!-- 配置获取连接等待超时的时间 -->
	// <property name="maxWait" value="60000" />
	//
	// <!-- 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 -->
	// <property name="timeBetweenEvictionRunsMillis" value="60000" />
	//
	// <!-- 配置一个连接在池中最小生存的时间，单位是毫秒 -->
	// <property name="minEvictableIdleTimeMillis" value="300000" />
	//
	// <property name="validationQuery" value="SELECT 'x'" />
	// <property name="testWhileIdle" value="true" />
	// <property name="testOnBorrow" value="false" />
	// <property name="testOnReturn" value="false" />
	//
	// <!-- 打开PSCache，并且指定每个连接上PSCache的大小 -->
	// <property name="poolPreparedStatements" value="true" />
	// <property name="maxPoolPreparedStatementPerConnectionSize" value="20" />
	//
	// <!-- 配置监控统计拦截的filters -->
	// <property name="filters" value="stat" />
	// </bean>
}
