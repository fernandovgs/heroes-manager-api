package com.digitalinnovationone.heroesmanagerapi.service;

import com.digitalinnovationone.heroesmanagerapi.document.Heroes;
import com.digitalinnovationone.heroesmanagerapi.repository.HeroesRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HeroesService {
    private final HeroesRepository heroesRepository;

    public Flux<Heroes> findAll() {
        return Flux.fromIterable(this.heroesRepository.findAll());
    }

    public Mono<Heroes> findById(String id) {
        return Mono.justOrEmpty(this.heroesRepository.findById(id));
    }

    public Mono<Heroes> save(Heroes heroes) {
        return Mono.justOrEmpty(this.heroesRepository.save(heroes));
    }

    public Mono<Boolean> deleteById(String id) {
        this.heroesRepository.deleteById(id);
        return Mono.just(true);
    }
}
