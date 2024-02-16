package com.ty.configuration;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ty")
public class MyConfig {

	@Bean
	public Scanner getScanner() {
		return new Scanner(System.in);
	}

	@Bean
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vikas").createEntityManager();
	}
}
