package com.digitalinnovationone.heroesmanagerapi;

import com.digitalinnovationone.heroesmanagerapi.repository.HeroesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.digitalinnovationone.heroesmanagerapi.constants.HeroesConstants.HEROES_ENDPOINT_LOCAL;


@ExtendWith(SpringExtension.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
class HeroesManagerApiApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Autowired
	HeroesRepository heroesRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void getOneHeroById() {
		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"), "3")
			.exchange()
			.expectStatus().isOk()
			.expectBody();
	}

	@Test
	void getOneHeroNotFound() {
		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"), "28743")
				.exchange()
				.expectStatus().isNotFound();
	}

	@Test
	void deleteHero() {
		webTestClient.delete().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"), "7")
				.exchange()
				.expectStatus().isOk()
				.expectBody(Void.class);
	}

	@Test
	void deleteHeroNotFound() {
		webTestClient.delete().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"), "7")
				.exchange()
				.expectStatus().is5xxServerError();
	}
}
