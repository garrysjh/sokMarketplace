package com.stringofkisses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@ComponentScan(basePackages = "com.stringofkisses")
@SpringBootApplication(scanBasePackages = "com.stringofkisses.api", exclude = SecurityAutoConfiguration.class)
public class StringofKisses {

	public static void main(String[] args) {
		SpringApplication.run(StringofKisses.class, args);
	}

}
