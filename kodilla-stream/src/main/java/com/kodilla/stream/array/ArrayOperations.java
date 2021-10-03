package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {

     static double getAverage(int[] numbers) {
         System.out.println("Collection of 20 random numbers:");

         IntStream.range(0, numbers.length)
                 .map(n -> numbers[n])
                 .forEach(System.out::println);


        return IntStream.range(0, numbers.length)
                 .map(n -> numbers[n])
                 .average().getAsDouble();
     }
}
