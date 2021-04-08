package com.digitalinnovationone.heroesmanagerapi.repository;

import com.digitalinnovationone.heroesmanagerapi.document.Heroes;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface HeroesRepository extends CrudRepository<Heroes, String> {
}
