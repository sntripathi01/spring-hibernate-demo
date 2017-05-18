/**
 * 
 */
package com.spring.hibernate.springhibernatedemo.config;

import java.io.IOException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.hibernate.springhibernatedemo.controller.User;

/**
 * @author stripathi1
 *
 */
@Configuration
public class HibernateConfig {
	@Bean
	@Qualifier("sessionFactory")
	public SessionFactory getSessionFactory() throws IOException {
		// Create configuration instance
		org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
		// Create properties file
		Properties properties = new Properties();
		properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
		// Pass hibernate properties file
		configuration.setProperties(properties);
		configuration.addAnnotatedClass(User.class);

		// Since version 4.x, service registry is being used
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		// Create session factory instance
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		return factory;
	}

	@Bean
	@Qualifier("mockSessionFactory")
	public SessionFactory mockSessionFactory() throws IOException {
		System.out.println("mockSessionFactory bean creation");
		// Create configuration instance
		org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
		// Create properties file
		Properties properties = new Properties();
		properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("test-hibernate.properties"));
		// Pass hibernate properties file
		configuration.setProperties(properties);
		configuration.addAnnotatedClass(User.class);

		// Since version 4.x, service registry is being used
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		// Create session factory instance
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		return factory;
	}

}
