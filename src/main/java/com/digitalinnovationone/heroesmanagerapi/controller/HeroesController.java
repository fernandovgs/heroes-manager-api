package com.digitalinnovationone.heroesmanagerapi.controller;

import com.digitalinnovationone.heroesmanagerapi.document.Heroes;
import com.digitalinnovationone.heroesmanagerapi.service.HeroesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.digitalinnovationone.heroesmanagerapi.constants.HeroesConstants.HEROES_ENDPOINT_LOCAL;

@RestController
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HeroesController {
    HeroesService heroesService;

    @GetMapping(HEROES_ENDPOINT_LOCAL)
    public Flux<Heroes> getAllHeroes() {
        log.info("Requesting list of all heroes");
        return heroesService.findAll();
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    public Mono<ResponseEntity<Heroes>> findById(@PathVariable String id) {
        log.info("requesting hero with id {}", id);
        return heroesService.findById(id)
                .map(item -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono<Heroes> createHero(@RequestBody Heroes heroes) {
        log.info("Persisting new hero on db");
        return heroesService.save(heroes);
    }

    @DeleteMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    public Mono<HttpStatus> deleteById(@PathVariable String id) {
        log.info("removing hero by id {}", id);
        heroesService.deleteById(id);
        return Mono.just(HttpStatus.CONTINUE);
    }
}
