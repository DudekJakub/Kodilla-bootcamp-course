package kursJava.tablice;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ZadaniaTestoweMain {

    int[] arrayEven = {0,2,4,6,8,10};
    int[] arrayOdd = {1,3,5,7,9,11,13,15,17,19,21};

    int[] someArray = {1,2,3,20,4,5,2,2,5,90,3,4,1};

    String[] strArray = {"moja", "mala", "zorka!"};

//  Napisz program, który wypisze co drugi element zdefiniowanych przez Ciebie tablic.
//  Pierwsza tablica powinna mieć parzystą liczbę elementów, a druga nieparzystą.

    private void everySecondRecordOfArray(@NotNull int[] arrayEven, int[] arrayOdd) {

        if(arrayEven.length > arrayOdd.length) {
            for (int j = 0; j < arrayOdd.length; j++) {
                System.out.print(arrayEven[j] + ", " + arrayOdd[j] + ", ");
            }
            for (int i = arrayOdd.length; i < arrayEven.length; i++) {
                System.out.print(arrayEven[i] + ", ");
            }
        } else {
            for (int j = 0; j < arrayEven.length; j++) {
                System.out.print(arrayEven[j] + ", " + arrayOdd[j] + ", ");
            }
            if(arrayOdd.length> arrayEven.length) {
                for (int i = arrayEven.length; i < arrayOdd.length; i++) {
                    System.out.print(arrayOdd[i] + ", ");
                };
            }
        }
    }

//    Napisz program, który wypisze największą liczbę z tablicy.
//    Tablicę zainicjalizuj przykładowymi wartościami.

    private int theBiggestNumberInArray(@NotNull int[] intArray) {

        int result = 0;

        int[] array = Arrays.stream(intArray).sorted().toArray();
        result = array[array.length-1];

        return result;
    }

//    Napisz program, w którym zdefiniujesz tablicę wartości typu String i zainicjalizujesz ją przykładowymi wartościami.
//    Skorzystaj z pętli for-each, aby wypisać wszystkie wartości tablicy ze wszystkimi literami zamienionymi na wielkie.
//    Skorzystaj z funkcjonalności toUpperCase wartości typu String, którą poznaliśmy już w jednym z poprzednich rozdziałów.

    private void makeAllLettersUpperCase(@NotNull String[] stringArray) {

        for (String s : stringArray) {
            System.out.print(s.toUpperCase() + " ");
        }
    }

//    Napisz program, który pobierze od użytkownika pięć słów i zapisze je w tablicy.
//    Następnie, program powinien wypisać wszystkie słowa, od ostatniego do pierwszego, z literami zapisanymi od końca do początku.
//    Dla przykładu, dla podanych słów "Ala", "ma", "kota", "i", "psa" program powinien wypisać: "asp", "i", "atok", "am", "alA".

    private static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    private void takeStringsFromUserAndMakeTheseWordsReverse(List<String> listForArray) {

        List<String> resultList = new ArrayList<>();

        for (String s : listForArray) {
            resultList.add(reverseString(s));
        }

        String[] strArray = {resultList.get(0), resultList.get(1), resultList.get(2), resultList.get(3), resultList.get(4)};

        for (int i = strArray.length-1; i >= 1; i--) {
            System.out.print(strArray[i] + ", ");
        }
        System.out.println(strArray[0]);
    }

//    Napisz program, który pobierze od użytkownika osiem liczb, zapisze je w tablicy, a następnie posortuje tą tablicę rosnąco i wypisze wynik sortowania na ekran.
//    Dla przykładu, dla liczb 10, -2, 1, 100, 20, -15, 0, 10, program wypisze -15, -2, 0, 1, 10, 10, 20, 100.
//    Zastanów się, jak można posortować ciąg liczb i spróbuj zaimplementować swoje rozwiązanie.
//    Przetestuj je na różnych zestawach danych.
//    Możesz też skorzystać z jednego z popularnych algorytmów sortowania, np. sortowania przez wstawianie. Opis tego algorytmu znajdziesz w internecie.

    private void sortingArrayNumbersGotFromUser(List<Integer> listForArray) {

        int[] intArray = {listForArray.get(0), listForArray.get(1), listForArray.get(2), listForArray.get(3),
                          listForArray.get(4), listForArray.get(5), listForArray.get(6), listForArray.get(7)};

        int[] resultArray = Arrays.stream(intArray).sorted().toArray();

        System.out.println(Arrays.toString(resultArray));
    }

//    Napisz program, który pobierze od użytkownika pięć liczb, zapisze je w tablicy, a następnie policzy i wypisze silnię każdej z pobranych liczb.

    private void strong(List<Integer> someUserNumbers) {

        int[] intArray = {someUserNumbers.get(0), someUserNumbers.get(1), someUserNumbers.get(2), someUserNumbers.get(3), someUserNumbers.get(4)};
        List<Integer> strongList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();

        int iniNumb = 0;
        int resultNumber;

        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j <= intArray[i]; j++) {
                iniNumb++;
                strongList.add(iniNumb);
                if(iniNumb == intArray[i]) {
                    resultNumber = strongList.stream().reduce(1, (x,y) -> x*y);
                    resultList.add(resultNumber);
                    iniNumb = 0;
                    strongList.clear();
                }
            }
        }
        for (Integer n : resultList) {
            if (n.equals(resultList.get(resultList.size() - 1))){
                System.out.println(n);
                break;
            }
            System.out.print(n + ", ");
        }
    }

//    Napisz program, w którym zdefiniujesz dwie tablice przechowujące wartości typu String.
//    Zainicjalizuj obie tablice takimi samymi wartościami, w takiej samej kolejności. 
//    Napisz kod, który porówna obie tablice i odpowie na pytanie, czy są one takie same.
    
    private String compareTwoStringArrays() {
        String[] strArray1 = {"Ala", "ma", "kota"};
        String[] strArray2 = {"Ala", "ma", "kotaa"};

        boolean equalStatus = false;

        for (String value : strArray1) {
            for (String s : strArray2) {
                equalStatus = value.equals(s);
            }
        }

        if(equalStatus) {
            return "These arrays are EQUAL";
        }

        return "Theses arrays ARE NOT EQUAL";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int counter = 0;

        ZadaniaTestoweMain zT = new ZadaniaTestoweMain();



//        System.out.println("ZADANIE 1");
//        zT.everySecondRecordOfArray(zT.arrayEven, zT.arrayOdd);
//
//
//
//        System.out.println("\n\nZADANIE 2");
//        System.out.println(zT.theBiggestNumberInArray(zT.someArray));
//
//
//
//        System.out.println("\nZADANIE 3");
//        zT.makeAllLettersUpperCase(zT.strArray);
//
//
//
//        System.out.println("\nZADANIE 4");
//        List<String> strList = new ArrayList<>();
//            while (strList.size() < 5) {
//                counter++;
//                System.out.println("Proszę podać słowo nr. " + counter);
//                String str = scanner.nextLine();
//                strList.add(str);
//            }
//            counter = 0;
//        zT.takeStringsFromUserAndMakeTheseWordsReverse(strList);
//
//
//
//        System.out.println("\nZADANIE 5");
//        List<Integer> intList = new ArrayList<>();
//            while (intList.size() < 8) {
//                counter++;
//                System.out.println("Proszę podać liczbę nr. " + counter);
//                int numb = scanner.nextInt();
//                intList.add(numb);
//            }
//            counter = 0;
//        zT.sortingArrayNumbersGotFromUser(intList);



//        System.out.println("\nZADANIE 6");
//        List<Integer> task6List = new ArrayList<>();
//            while (task6List.size() < 5) {
//                counter++;
//                System.out.println("Proszę podać liczbę nr. " + counter);
//                int numb = scanner.nextInt();
//                task6List.add(numb);
//            }
//            counter = 0;
//        zT.strong(task6List);



        System.out.println("\nZADANIE 7");
        System.out.println(zT.compareTwoStringArrays());
    }
}
