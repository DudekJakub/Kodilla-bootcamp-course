package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.predictors.AggressivePredictor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTestSuite {

    @Test
    void testDefaultInvestingStrategies() {
        //Given
        Customer jakub = new IndividualCustomer("Jakub Dudek");
        Customer martyna = new IndividualYoungCustomer("Martyna Bykowska");
        Customer kodilla = new CorporateCustomer("Kodilla");

        //When
        String jakubShouldBuy = jakub.predict();
        System.out.println("Jakub should: " + jakubShouldBuy);
        String martynaShouldBuy = martyna.predict();
        System.out.println("Martyna should: " + martynaShouldBuy);
        String kodillaShouldBuy = kodilla.predict();
        System.out.println("Kodilla should: " + kodillaShouldBuy);

        //Then
        Assertions.assertEquals("[Conservative predictor] Buy debentures of XYZ", jakubShouldBuy);
        Assertions.assertEquals("[Aggressive predictor] Buy stock of XYZ", martynaShouldBuy);
        Assertions.assertEquals("[Balanced predictor] Buy shared units of Fund XYZ", kodillaShouldBuy);
    }

    @Test
    void testIndividualInvestingStrategy() {
        //Given
        Customer jakub = new IndividualCustomer("Jakub Dudek");

        //When
        String jakubShouldBuy = jakub.predict();
        System.out.println("Jakub should: " + jakubShouldBuy);
        jakub.setBuyingStrategy(new AggressivePredictor());
        jakubShouldBuy = jakub.predict();
        System.out.println("Jakub now should: " + jakubShouldBuy);

        //Then
        Assertions.assertEquals("[Aggressive predictor] Buy stock of XYZ", jakubShouldBuy);
    }
}
