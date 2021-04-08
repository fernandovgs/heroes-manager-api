package com.digitalinnovationone.heroesmanagerapi.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;

import static com.digitalinnovationone.heroesmanagerapi.constants.HeroesConstants.*;

public class HeroesData {
    public static void main(String[] args) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable(HEROES_TABLE);
        Item firstHero = new Item()
                .withPrimaryKey(HEROES_TABLE_ID, "1")
                .withString(HEROES_TABLE_NAME, "Wonder Woman")
                .withString(HEROES_TABLE_UNIVERSE, "DC")
                .withNumber(HEROES_TABLE_FILMS, 3);
        Item secondHero = new Item()
                .withPrimaryKey(HEROES_TABLE_ID, "2")
                .withString(HEROES_TABLE_NAME, "Black Widow")
                .withString(HEROES_TABLE_UNIVERSE, "Marvel")
                .withNumber(HEROES_TABLE_FILMS, 2);
        Item thirdHero = new Item()
                .withPrimaryKey(HEROES_TABLE_ID, "3")
                .withString(HEROES_TABLE_NAME, "Captain Marvel")
                .withString(HEROES_TABLE_UNIVERSE, "Marvel")
                .withNumber(HEROES_TABLE_FILMS, 2);

        try {
            table.putItem(firstHero);
            table.putItem(secondHero);
            table.putItem(thirdHero);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
