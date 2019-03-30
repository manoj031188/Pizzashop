package com.pizzashop.testproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.pizzashop.*")
@SpringBootApplication
public class TestprojectApplication {

	private static final Logger log = LoggerFactory.getLogger(TestprojectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TestprojectApplication.class, args);
		log.info("Application Started");
	}

}
