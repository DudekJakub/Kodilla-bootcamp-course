import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Scanner;

public class choinkaMain {

    private void christmassTreeGenerator(int number) {
        String star = "*";
        StringBuilder result = new StringBuilder(star);

        System.out.println(StringUtils.center(star, number));
        while(result.length()<number){
            result.append(star);
            if (result.length() % 2 == 0 && number % 2 == 0) {
                System.out.println(StringUtils.center(String.valueOf(result), number));
            }
            if (result.length() % 2 != 0 && number % 2 != 0) {
                System.out.println(StringUtils.center(String.valueOf(result), number));
            }
        }
    }

    public static void main(String[] args) {
        Scanner typedNumber = new Scanner(System.in);
        choinkaMain choinkaMain = new choinkaMain();

        boolean christmassEvent = true;
        String intro = "Podaj liczbę do utworzenia choinki:";
        String error = "Proszę podać liczbę większą niż 3. Choinka musi przecież na czymś stać!";

        while(christmassEvent) {
            System.out.println(StringUtils.center(intro, error.length()/2));
            int number = typedNumber.nextInt();

            if (number > 3) {
                choinkaMain.christmassTreeGenerator(number);
                christmassEvent = false;
            } else {
                System.out.println(error);
            }
        }
    }
}
