package com.example.arquiteturaSpring;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ArquiteturaSpringApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ArquiteturaSpringApplication.class, args);

		SpringApplicationBuilder builder = new SpringApplicationBuilder(ArquiteturaSpringApplication.class);

		builder.bannerMode(Banner.Mode.OFF);
		ConfigurableApplicationContext applicationContext = builder.context();
		builder.run(args);
	}
}
