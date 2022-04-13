package SRP.exerciseCar.after_refactored;

import java.util.List;

public class CarRater {

    public Car getBestCar(List<Car> carList) {
        Car bestCar = null;
        for (Car car : carList) {
            if (bestCar == null || car.getModel().compareTo(bestCar.getModel()) > 0) {
                bestCar = car;
            }
        }
        return bestCar;
    }
}
