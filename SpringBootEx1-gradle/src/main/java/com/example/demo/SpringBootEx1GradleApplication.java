package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan("rest.*")
@ComponentScan("com.*")
public class SpringBootEx1GradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEx1GradleApplication.class, args);
	}

}
