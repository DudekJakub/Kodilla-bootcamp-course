package SRP.exerciseCar.after_refactored;

import java.util.List;

public class CarManager {

    private final CarDAO carDAO;
    private final CarsPrinter carsPrinter;
    private final CarRater carRater;

    public CarManager(CarDAO carDAO, CarsPrinter carsPrinter, CarRater carRater) {
        this.carDAO = carDAO;
        this.carsPrinter = carsPrinter;
        this.carRater = carRater;
    }

    public Car getCarById(String carId) {
        return carDAO.findById(carId);
    }

    public List<Car> getAllCars() {
        return carDAO.findAll();
    }

    public Car getBestCar() {
        return carRater.getBestCar(this.getAllCars());
    }

    public String printCars() {
        return carsPrinter.printAllCars();
    }
}
