package com.eiecc.fire.spring_4_no_xml.mvc.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.eiecc.fire.spring_4_no_xml.mvc.data.FireDataSource;

@Configuration
@EnableJpaRepositories("com.eiecc.fire.spring_4_no_xml.mvc.data.repository")//WebInitializer实现WebApplicationInitializer接口必须加上，不然找到包
public class JpaConfig {

	@Autowired
	@Qualifier("CUDDataSource")
	private FireDataSource fireDataSource;

	/*public JpaConfig(FireDataSource fireDataSource) {
		this.fireDataSource = fireDataSource;
	}*/

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

		em.setDataSource(fireDataSource.dataSource());

		// 指定实体类的路径
		em.setPackagesToScan(new String[] { "com.eiecc.fire.spring_4_no_xml.mvc.domain" });

		// 指定Jpa持久化实现厂商类,这里以Hibernate为例
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);

		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		/*
		 * jpaProperties.setProperty("hibernate.show_sql", "true");
		 * jpaProperties.setProperty("hibernate.format_sql", "true");
		 */
		// jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");

		em.setJpaProperties(jpaProperties);
		// em.setPersistenceUnitName("jpa-hibernate");
		// em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		return em;

	}

	// @Bean
	// public PlatformTransactionManager transactionManager(EntityManagerFactory
	// emf) {
	// JpaTransactionManager transactionManager = new JpaTransactionManager();
	// transactionManager.setEntityManagerFactory(emf);
	//
	// return transactionManager;
	// }
	//
	// @Bean
	// public PersistenceExceptionTranslationPostProcessor
	// exceptionTranslation() {
	// return new PersistenceExceptionTranslationPostProcessor();
	// }

}
