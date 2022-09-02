package com.example.PhoneBook;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableJpaAuditing
@SpringBootApplication
public class PhoneBookApplication {

public static void main(String[] args) {

	new SpringApplicationBuilder(PhoneBookApplication.class)
			.bannerMode(Banner.Mode.OFF)
			.run(args);

	}

}
