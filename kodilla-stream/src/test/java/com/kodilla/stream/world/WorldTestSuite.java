package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    void testGetCountriesOfContinent() {
        //Given
        Continent europe = new Continent("Europe");
            Country poland = new Country("Poland", new BigDecimal("38000000"));
            Country germany = new Country("Germany", new BigDecimal("78000000"));

        Continent asia = new Continent("Asia");
            Country chines = new Country("Chines", new BigDecimal("1300000000"));
            Country afghanistan = new Country("Afghanistan", new BigDecimal("30000000"));

        Continent africa = new Continent("Africa");
            Country kongo = new Country("Kongo", new BigDecimal("40000000"));
            Country rpa = new Country("RPA", new BigDecimal("55000000"));

        Continent northAmerica = new Continent("North America");
            Country usa = new Country("USA", new BigDecimal("329000000"));

        Continent southAmerica = new Continent("South America");
            Country brasil = new Country("Brasil", new BigDecimal("680000000"));

        World world = new World();

        //When
        europe.addCountry(poland);
        europe.addCountry(germany);

        asia.addCountry(chines);
        asia.addCountry(afghanistan);

        africa.addCountry(kongo);
        africa.addCountry(rpa);

        northAmerica.addCountry(usa);

        southAmerica.addCountry(brasil);

        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);
        world.addContinent(northAmerica);
        world.addContinent(southAmerica);

        //Then
        Assertions.assertEquals(new BigDecimal("38000000"), poland.getPoepleQuantity());

        Assertions.assertEquals(2, europe.getCountriesOfContinent().size());
        Assertions.assertEquals(new BigDecimal("116000000"), europe.getContinentPopulation());
        System.out.println(europe.getCountriesOfContinent() + " EUROPE population = " + europe.getContinentPopulation());

        Assertions.assertEquals(2, asia.getCountriesOfContinent().size());
        Assertions.assertEquals(new BigDecimal("1330000000"), asia.getContinentPopulation());
        System.out.println(asia.getCountriesOfContinent() + " ASIA population = " + asia.getContinentPopulation());

        Assertions.assertEquals(2, africa.getCountriesOfContinent().size());
        Assertions.assertEquals(new BigDecimal("95000000"), africa.getContinentPopulation());
        System.out.println(africa.getCountriesOfContinent() + " AFRICA population = " + africa.getContinentPopulation());

        Assertions.assertEquals(1, northAmerica.getCountriesOfContinent().size());
        Assertions.assertEquals(new BigDecimal("329000000"), northAmerica.getContinentPopulation());
        System.out.println(northAmerica.getCountriesOfContinent() + " NORTH-AMERICA population = " + northAmerica.getContinentPopulation());

        Assertions.assertEquals(1, southAmerica.getCountriesOfContinent().size());
        Assertions.assertEquals(new BigDecimal("680000000"), southAmerica.getContinentPopulation());
        System.out.println(southAmerica.getCountriesOfContinent() + " SOUTH-AMERICA population = " + southAmerica.getContinentPopulation());

        Assertions.assertEquals(new BigDecimal("2550000000"), world.getPeopleQuantity());
        System.out.println("WORLD POPULATION = " + world.getPeopleQuantity());





    }
}
