package com.example.Quizzes_Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class QuizzesApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizzesApplication.class, args);
	}

}
