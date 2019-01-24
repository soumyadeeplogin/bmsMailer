package com.bms.mail.bmsMailer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BmsMailerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BmsMailerApplication.class, args);
	}

}

