package com.digitalinnovationone.heroesmanagerapi.constants;

public class HeroesConstants {
    private HeroesConstants() {
        throw new IllegalStateException("This class is not meant to be instantiated.");
    }

    public static final String HEROES_ENDPOINT_LOCAL = "/heroes";
    public static final String ENDPOINT_DYNAMO = "http://localhost:8000";
    public static final String REGION_DYNAMO = "sa-east-1";

    public static final String HEROES_TABLE = "Heroes_Table";
    public static final String HEROES_TABLE_ID = "id";
    public static final String HEROES_TABLE_NAME = "name";
    public static final String HEROES_TABLE_UNIVERSE = "universe";
    public static final String HEROES_TABLE_FILMS = "films";
}
