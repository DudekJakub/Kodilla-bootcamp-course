package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        System.out.println("Test - pierwszy test jednostkowy:");

        Calculator calculator = new Calculator();

        int resultAdd = calculator.add(2, 2);
        int resultSubstract = calculator.subtract(2, 2);

        if (resultAdd == 4) {
            System.out.println("Dodawanie wykonano poprawnie: " + resultAdd);
        } else {
            System.out.println("ERROR: Wynik jest inny od zakładanego, tj. 4");
        }

        if (resultSubstract == 0) {
            System.out.println("Odejmowanie wykonano poprawnie: " + resultSubstract);
        } else {
            System.out.println("ERROR: Wynik jest inny od zakładanego (tj. 0)");
        }
    }
}