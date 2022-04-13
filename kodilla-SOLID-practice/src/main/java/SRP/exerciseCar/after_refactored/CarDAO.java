package SRP.exerciseCar.after_refactored;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CarDAO {

    private List<Car> carList = Arrays.asList(
            new SRP.exerciseCar.after_refactored.Car("1", "Gold III", "Volkswagen"),
            new SRP.exerciseCar.after_refactored.Car("2", "Multipla", "Fiat"),
            new SRP.exerciseCar.after_refactored.Car("3", "Megane", "Renault")
    );

    public Car findById(String carId) {
        Car returnedCar = null;
        for (Car car : carList) {
            if (car.getId().equals(carId)) {
                returnedCar = car;
                return returnedCar;
            }
        }
        return null;
    }

    public List<Car> findAll() {
        return new LinkedList<>(carList);
    }
}
