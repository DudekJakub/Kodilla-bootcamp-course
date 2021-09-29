package com.kodilla.testing;

import com.kodilla.testing.collection.OddNumbersExterminator;
import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestingMain {

    public static void main(String[] args) {

        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();

        ArrayList <Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        lista.add(6);
        lista.add(7);
        lista.add(8);

        //System.out.println(oddNumbersExterminator.exterminate(lista));

        Temperatures temperatures = new Temperatures() {
            @Override
            public Map<String, Double> getTemperatures() {
                Map<String, Double> temperaturesMap = new HashMap<>();
                temperaturesMap.put("Poznań", 20.0);
                temperaturesMap.put("Mosina", 18.0);
                temperaturesMap.put("Żabno", 19.0);
                temperaturesMap.put("Kraków", 22.0);

                return temperaturesMap;
            }
        };

        WeatherForecast weatherForecast = new WeatherForecast(temperatures);
        System.out.println(weatherForecast.calculateAverageTemperature());
        System.out.println(weatherForecast.calculateMedianTemperature());

    }
}