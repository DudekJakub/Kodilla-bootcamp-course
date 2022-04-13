import SRP.exerciseCar.after_refactored.CarDAO;
import SRP.exerciseCar.after_refactored.CarRater;
import SRP.exerciseCar.after_refactored.CarsPrinter;
import SRP.exerciseCar.before_refactored.CarManager;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        CarManager carManager = new CarManager();
        SRP.exerciseCar.after_refactored.CarManager carManager_AFTER = new SRP.exerciseCar.after_refactored.CarManager(new CarDAO(), new CarsPrinter(), new CarRater());
//
//        System.out.println(carManager.getCarsName());
//
//        System.out.println(carManager.getBestCar());

        carManager.compareCars(carManager.getFromDb("2"), carManager.getFromDb("1"));

        System.out.println(compareStrings("multipla", "gold"));

        System.out.println("AFTER REFACTORING:\n'getAllCars'");
        System.out.println(carManager_AFTER.getAllCars() + "\n\n'getBestCar'\n" + carManager_AFTER.getBestCar()
                                + "\n\n'getCarById'\n" + carManager_AFTER.getCarById("1") + "\n\n'printAllCars'\n" + carManager_AFTER.printCars());
    }

    static int compareStrings(String first, String second) {

        List<Character> alfabet = Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');

        int distanceOfFirstChar = 0;
        int distanceOfSecondChar = 0;
        char firstStringDiff = 'a';
        char secondStringDiff = 'b';
        boolean charsNotEquals = false;


        for (int i = 0; i < first.length(); i++) {
            for (int j = 0; j < second.length(); j++) {
                if (first.charAt(i) != second.charAt(j)){
                    charsNotEquals = true;
                    firstStringDiff = first.charAt(i);
                    secondStringDiff = second.charAt(j);
                    break;
                }
            }
            if (charsNotEquals) break;
        }

        for (int k = 0; k < alfabet.size(); k++) {
            if (alfabet.get(k).equals(firstStringDiff)){
                distanceOfFirstChar = k;
            } else if (alfabet.get(k).equals(secondStringDiff)) {
                distanceOfSecondChar = k;
            }
        }

        return distanceOfFirstChar - distanceOfSecondChar;
    }
}
