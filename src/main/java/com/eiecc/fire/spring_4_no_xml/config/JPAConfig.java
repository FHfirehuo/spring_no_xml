package com.eiecc.fire.spring_4_no_xml.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
// @EnableTransactionManagement
public class JPAConfig {

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

	/*@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_jpa");
		dataSource.setUsername("tutorialuser");
		dataSource.setPassword("tutorialmy5ql");
		return dataSource;
	}*/

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

		em.setDataSource(dataSource());

		// 指定实体类的路径
		em.setPackagesToScan(new String[] { "com.ciecc.fire.spring_4_no_xml" });

		// 指定Jpa持久化实现厂商类,这里以Hibernate为例
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);

		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		/*
		 * jpaProperties.setProperty("hibernate.show_sql", "true");
		 * jpaProperties.setProperty("hibernate.format_sql", "true");
		 */
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");

		em.setJpaProperties(jpaProperties);
		// em.setPersistenceUnitName("jpa-hibernate");
		// em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		return em;

	}

	/*
	 * @Bean public PlatformTransactionManager
	 * transactionManager(EntityManagerFactory emf) { JpaTransactionManager
	 * transactionManager = new JpaTransactionManager();
	 * transactionManager.setEntityManagerFactory(emf);
	 * 
	 * return transactionManager; }
	 * 
	 * @Bean public PersistenceExceptionTranslationPostProcessor
	 * exceptionTranslation() { return new
	 * PersistenceExceptionTranslationPostProcessor(); }
	 */

	//Spring Data REST在根URI“/”处提供REST资源。 有多种方法可以更改基本路径
	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {

		return new RepositoryRestConfigurerAdapter() {

			@Override
			public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
				config.setBasePath("/api");
			}
		};
	}
	
	//或者，只需将RepositoryRestConfigurer的自定义实现注册为Spring bean，并确保它通过组件扫描获取。见CustomizedRestMvcConfig
}
