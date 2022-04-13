package LSP.exerciseDuck.after_refactored;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pool {

    public void run() {
        Duck donaldDuck = new Duck();
        ElectronicDuck electronicDuck = new ElectronicDuck();
        electronicDuck.turnOn(); //for tests
        for (IDuck duck : Arrays.asList(donaldDuck, electronicDuck)) {
            try {
                duck.quack();
                duck.swim();
            } catch (IDuckException e) {
                e.printStackTrace();
            }
        }
    }

    public void quack(IDuck duck)  {
        try {
            duck.quack();
        } catch (IDuckException e) {
            e.printStackTrace();
        }
    }

    public void swim(IDuck duck) {
        try {
            duck.swim();
        } catch (IDuckException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Pool pool = new Pool();
        pool.run();
    }
}
