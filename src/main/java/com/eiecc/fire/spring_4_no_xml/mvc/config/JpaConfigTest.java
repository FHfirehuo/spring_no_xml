package com.eiecc.fire.spring_4_no_xml.mvc.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.eiecc.fire.spring_4_no_xml.mvc.data.FireDataSource;

@Configuration
@EnableJpaRepositories//激活Spring Data JPA存储库
@EnableTransactionManagement
public class JpaConfigTest {

	
	@Autowired
	@Qualifier("RDataSource")
	private FireDataSource fireDataSource;
	
	/*@Bean
	public DataSource dataSource() {
		//设置嵌入式HSQL数据库
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		return builder.setType(EmbeddedDatabaseType.HSQL).build();
	}*/

	/***
	 * 重要的是直接创建LocalContainerEntityManagerFactoryBean而不是EntityManagerFactory，
	 * 因为前者除了简单地创建EntityManagerFactory之外也参与异常翻译机制。
	 * 
	 * @return
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		//使用Hibernate作为样例持久化提供者
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.acme.domain");
		factory.setDataSource(fireDataSource.dataSource());
		return factory;
	}

	/*@Bean
	public PlatformTransactionManager transactionManager() {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory((EntityManagerFactory) entityManagerFactory());
		return txManager;
	}*/
}
