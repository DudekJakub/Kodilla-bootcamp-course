package SRP.exerciseCar.after_refactored;

public class CarsPrinter {

    private final CarDAO carDAO = new CarDAO();

    public final String printAllCars() {
        StringBuilder sb = new StringBuilder();
        for (Car car : carDAO.findAll()) {
            sb.append(car.getModel());
            sb.append(" ");
            sb.append(car.getBrand());
            sb.append(", ");
        }

        return sb.substring(0, sb.length() - 2);
    }
}
