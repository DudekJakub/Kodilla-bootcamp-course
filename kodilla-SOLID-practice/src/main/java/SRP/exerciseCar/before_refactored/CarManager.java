package SRP.exerciseCar.before_refactored;

import java.util.Arrays;
import java.util.List;

public class CarManager {

    private List<Car> carsFromDb = Arrays.asList(
            new Car("1", "Gold III", "Volkswagen"),
            new Car("2", "Multipla", "Fiat"),
            new Car("3", "Megane", "Renault")
            );

    public Car getFromDb(final String carId) {

        for (Car car : carsFromDb) {
            if (car.getId().equals(carId)) {
                return car;
            }
        }
        return null;
    }

    public String getCarsName() {

        StringBuilder sb = new StringBuilder();

        for (Car car : carsFromDb) {
            sb.append(car.getBrand());
            sb.append(" ");
            sb.append(car.getModel());
            sb.append(", ");
        }

        return sb.substring(0, sb.length() -2 );
    }

    public Car getBestCar() {

        Car bestCar = null;
        for (Car car : carsFromDb) {
            if (bestCar == null || car.getModel().compareTo(bestCar.getModel()) > 0) {
                bestCar = car;
            }
        }
        return bestCar;
    }

    public void compareCars(Car firstCar, Car secondCar) {

        System.out.println(firstCar.getModel().compareTo(secondCar.getModel()));
    }
}
