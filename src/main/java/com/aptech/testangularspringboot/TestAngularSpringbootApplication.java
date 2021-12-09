package com.aptech.testangularspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.File;

import static com.aptech.testangularspringboot.constant.FileConstant.USER_FOLDER;

@SpringBootApplication
public class TestAngularSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestAngularSpringbootApplication.class, args);
		new File(USER_FOLDER).mkdirs();
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
