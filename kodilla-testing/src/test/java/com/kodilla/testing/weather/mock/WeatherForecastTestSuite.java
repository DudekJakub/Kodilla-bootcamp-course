package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Weather Forecast Test Suite:")
public class WeatherForecastTestSuite {

    @BeforeEach
    public void beforeEveryTest() {
        System.out.println("Weather Forecast Test Case: begin");
    }

    @AfterEach
    public void afterEveryTest() {
        System.out.println("Weather Forecast Test Case: end \n");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Weather Forecast Test Suite: begin \n");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Weather Forecast Test Suite: end \n-------------");
    }

    @Mock
    private Temperatures temperaturesMock;

    @DisplayName("Test Forecast Map")
        @Test
        void testCalculateForecastWithMock() {
            //Given
            Map<String, Double> temperaturesMap = new HashMap<>();
            temperaturesMap.put("Poznań", 20.0);
            temperaturesMap.put("Mosina", 18.0);
            temperaturesMap.put("Żabno", 16.0);
            temperaturesMap.put("Kraków", 22.0);
            when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

            WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

            //When
            int quantityOfSensors = weatherForecast.calculateForecast().size();

            //Then
            Assertions.assertEquals(4, quantityOfSensors);

        }

    @DisplayName("Test Forecast Average Temperature")
        @Test
        void testCalculateAverageTemperaturesWithMock() {
            //Given
            Map<String, Double> temperaturesMap = new HashMap<>();
            temperaturesMap.put("Poznań", 20.0);
            temperaturesMap.put("Mosina", 18.0);
            temperaturesMap.put("Żabno", 16.0);
            temperaturesMap.put("Kraków", 22.0);
            when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

            WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

            //When
            double Result = weatherForecast.calculateAverageTemperature();
            double expectedResult = 19.0;

            //Then
            Assertions.assertEquals(expectedResult, Result);
            System.out.println(Result);
        }

    @DisplayName("Test Forecast Median Temperature")
        @Test
        void testCalculateMedianTemperatureWithMock() {
            //Given
            Map<String, Double> temperaturesMap = new HashMap<>();
            temperaturesMap.put("Poznań", 20.0);
            temperaturesMap.put("Mosina", 18.0);
            temperaturesMap.put("Żabno", 16.0);
            temperaturesMap.put("Kraków", 22.0);
            when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

            WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

            //When
            List<Double> Result = weatherForecast.calculateMedianTemperature();
            List<Double> expectedResult = new LinkedList<Double>();
            expectedResult.add(19.0);

            //Then
            Assertions.assertEquals(expectedResult, Result);
            System.out.println(Result);
        }
}
