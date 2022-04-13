package SRP.exerciseCar.after_refactored;

public class Car {

    private final String id;
    private final String model;
    private final String brand;

    public Car(String id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
