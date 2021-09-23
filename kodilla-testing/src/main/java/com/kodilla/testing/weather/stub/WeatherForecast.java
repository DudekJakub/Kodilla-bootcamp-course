package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature:
                temperatures.getTemperatures().entrySet()) {
                resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAverageTemperature() {
        Map<String, Double> resultMap1 = new HashMap<>();

        double iniNumber = 0;

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            resultMap1.put(temperature.getKey(), temperature.getValue());
            iniNumber = iniNumber + temperature.getValue();
        }
        System.out.println("Average temperature is: ");
        return iniNumber / resultMap1.size();

    }

    public List<Double> calculateMedianTemperature() {
        Map<String, Double> resultMap1 = new HashMap<>();
        List<Double> list = new LinkedList<Double>();
        List<Double> middle = null;

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {

            resultMap1.put(temperature.getKey(), temperature.getValue());

            list = new LinkedList<Double>(resultMap1.values());
            Collections.sort(list);
            if (list.size()%2 == 0) {
                middle = Collections.singletonList((list.get(list.size() / 2) + list.get((list.size() / 2) - 1)) / 2);
            } else {
                middle = Collections.singletonList(list.get(list.size() / 2));
            }
        }
        System.out.println("Sorted temperatures list: " + list);
        System.out.println("Median temperature is: ");
        return middle;
    }
}
