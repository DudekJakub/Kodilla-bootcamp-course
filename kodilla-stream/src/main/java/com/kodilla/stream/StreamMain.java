package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.util.Random;

public class StreamMain {

    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");

        Processor processor = new Processor();
        processor.execute(() -> System.out.println("This is an example text."));

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("\nCalculation expressions with lambdas");
        expressionExecutor.executeExpression(10, 10, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 10, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 10, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 10, (a, b) -> a / b);

        System.out.println("\nCalculation expressions with method references");
        expressionExecutor.executeExpression(10, 10, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(10, 10, FunctionalCalculator::divideAByB);
        expressionExecutor.executeExpression(10, 10, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(10, 10, FunctionalCalculator::divideAByB);

        Random random = new Random();

        System.out.println("\nString decoration with lambdas");
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Java is awesome!", example -> example.toUpperCase());
        poemBeautifier.beautify("This is an example text!afeasdfzefe ", example -> example.substring(0,24));
        poemBeautifier.beautify("I LOVE CODING... YET :)", example -> example.toLowerCase().replaceFirst("i", "I"));

        System.out.println("\nString decoration with method references");
        poemBeautifier.beautify("Java is awesome!", PoemBeautifier::toUpperCase);
        poemBeautifier.beautify("This is an example text!afeasdfzefe ", PoemBeautifier::substring);
        poemBeautifier.beautify("I LOVE CODING... YET :)", PoemBeautifier::toUpperCaseANDreplaceFirst);

        System.out.println("\nUsing Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);




    }
}