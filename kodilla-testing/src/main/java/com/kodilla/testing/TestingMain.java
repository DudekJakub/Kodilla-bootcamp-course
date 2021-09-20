package com.kodilla.testing;

import com.kodilla.testing.collection.OddNumbersExterminator;
import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TestingMain {
    public static void main(String[] args) {

        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();

        ArrayList <Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        lista.add(6);
        lista.add(7);
        lista.add(8);

        System.out.println(oddNumbersExterminator.exterminate(lista));


    }
}