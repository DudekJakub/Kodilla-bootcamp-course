package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        //------------------ 7.1 ------------------

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

        //------------------ 7.3 ------------------

        System.out.println("\n---------------\nUsing Stream at task 7.3:");
        People.getList().stream()
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);

        System.out.println("\n---------------\nSwitch lambda & method reference:");
        People.getList().stream()
                .map(String::toUpperCase)
                .forEach(s -> System.out.println(s));

        System.out.println("\n---------------\nLearning filtration:");
        People.getList().stream()
                .filter(s -> s.length() > 11)
                .forEach(System.out::println);

        System.out.println("\n---------------\nKaskadowe łączenie operacji na Streamach:");
        People.getList().stream()
                .map(s -> s.toUpperCase())
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(System.out::println);

        System.out.println("\n---------------\nStream na kolekcjach z dowolnymi obiektami:");
        BookDirectory theBookDirectory = new BookDirectory();
        theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .forEach(System.out::println);

        System.out.println("\n---------------\nOperacje terminalne – kolektory COLLECTOR.toList():");
        List<Book> theResultListOfBooks1 = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());

        System.out.println("#elements: " + theResultListOfBooks1.size());
        theResultListOfBooks1.stream()
                .forEach(System.out::println);

        System.out.println("\n---------------\nOperacje terminalne – kolektory COLLECTOR.toMap():");
        Map<String, Book> theResultListOfBooks2 = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("#elements: " + theResultListOfBooks2.size());
        theResultListOfBooks2.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        System.out.println("\n---------------\nOperacje terminalne – kolektory COLLECTOR.joining():");
        String theResultListOfBooks3 = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultListOfBooks3);



        //ZADANIE NR 7.3 DO SPRAWDZENIA

        System.out.println("\n---------------\n7.3 Task: funkcyjny spacer po liście użytkowników forum");
        Forum theForum = new Forum();

        System.out.println("\n--- PRZED --- \n" + "#elements: " + theForum.getUserList().size() + "\n" + theForum.getUserList());

        Map<Integer, ForumUser> theResultListOfForumUsers = theForum.getUserList().stream()
                .filter(forumUser -> forumUser.getUserSex() == 'M')
                .filter(forumUser -> forumUser.getBirthDate().getYear() <= 2001)
                .filter(forumUser -> forumUser.getUserPostQuantity() > 1)
                .collect(Collectors.toMap(ForumUser::getUserId, forumUser -> forumUser));

        System.out.println("\n--- PO ---");
        System.out.println("#elements: " + theResultListOfForumUsers.size());

        theResultListOfForumUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

    }
}