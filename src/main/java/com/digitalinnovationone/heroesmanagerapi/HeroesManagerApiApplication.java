package com.digitalinnovationone.heroesmanagerapi;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class HeroesManagerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeroesManagerApiApplication.class, args);
	}

}
