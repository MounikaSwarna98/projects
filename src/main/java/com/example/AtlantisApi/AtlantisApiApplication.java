package com.example.AtlantisApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.example.controller,com.example.service")
public class AtlantisApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtlantisApiApplication.class, args);
	}

}
