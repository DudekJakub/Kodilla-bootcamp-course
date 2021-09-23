package com.kodilla.testing.weather.stub;

import java.util.HashMap;
import java.util.Map;

public class TemperaturesStub implements Temperatures {

    @Override
    public Map<String, Double> getTemperatures() {
        Map<String, Double> stubResult = new HashMap<>();

        // dummy data
        stubResult.put("Poznań", 25.0);
        stubResult.put("Mosina", 24.3);
        stubResult.put("Żabno", 23.8);

        return stubResult;
    }
}
