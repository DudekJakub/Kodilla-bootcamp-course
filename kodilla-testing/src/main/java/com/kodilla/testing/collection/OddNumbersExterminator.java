package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    public static List<Integer> exterminate(List<Integer> numbers){
        ArrayList<Integer> oddExterminatedNumbersList = new ArrayList<>();

        for(int number : numbers){
            if(number % 2 == 0){
                oddExterminatedNumbersList.add(number);
            }
        }
        return oddExterminatedNumbersList;
    }
}
