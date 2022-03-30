import SRP.exerciseCar.before_refactored.CarManager;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        CarManager carManager = new CarManager();
//
//        System.out.println(carManager.getCarsName());
//
//        System.out.println(carManager.getBestCar());

        carManager.compareCars(carManager.getFromDb("2"), carManager.getFromDb("1"));

        System.out.println(compareStrings("multipla", "gold"));
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
