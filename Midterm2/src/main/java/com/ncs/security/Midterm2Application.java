package com.ncs.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ncs.security.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class Midterm2Application {

	public static void main(String[] args) {
		SpringApplication.run(Midterm2Application.class, args);
	}

}
