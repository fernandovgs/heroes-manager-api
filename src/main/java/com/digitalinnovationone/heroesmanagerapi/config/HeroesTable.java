package com.digitalinnovationone.heroesmanagerapi.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;

import java.util.Collections;

import static com.digitalinnovationone.heroesmanagerapi.constants.HeroesConstants.ENDPOINT_DYNAMO;
import static com.digitalinnovationone.heroesmanagerapi.constants.HeroesConstants.REGION_DYNAMO;

public class HeroesTable {
    public static void main(String[] args) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        String tableName = "Heroes_Table";

        try {
            Table table = dynamoDB.createTable(tableName,
                    Collections.singletonList(new KeySchemaElement("id", KeyType.HASH)
                    ),
                    Collections.singletonList(new AttributeDefinition("id", ScalarAttributeType.S)
                    ),
                    new ProvisionedThroughput(5L, 5L));
            table.waitForActive();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
