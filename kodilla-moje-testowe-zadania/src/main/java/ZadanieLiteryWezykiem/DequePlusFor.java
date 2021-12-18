package ZadanieLiteryWezykiem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public final class DequePlusFor {

    public static StringBuilder generatorLosowejIlosciLiterki(int maxLength, String letter) {

        Random random = new Random();
        StringBuilder a = new StringBuilder(letter);
        int len = random.nextInt(maxLength) + 1;

        while (a.length() < len) {
            a.append(letter);
        } return a;
    }

    public List<StringBuilder> literyWezykiem(int dequeLength, int maxLength, String letter, boolean sorted) {

        List<StringBuilder> list = new ArrayList<>();
        List<StringBuilder> listSortedCheck;
        StringBuilder separator = new StringBuilder("-");

        for (int i = 0; i < dequeLength; i++) {
            StringBuilder result = generatorLosowejIlosciLiterki(maxLength, letter);
            list.add(result);
        }

        if(sorted) {
            listSortedCheck = list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        } else {
            listSortedCheck = list;
        }

        while(separator.length() < 30) {
            separator.append(separator);
        }

        System.out.println("\nWSZYSTKIE LITERKI: ");
        for (StringBuilder showList : listSortedCheck) {
            System.out.println(showList + " " + showList.length());
        }
        System.out.println("LICZBA ELEMENTOW = " + listSortedCheck.size() + "\n" + separator);
        return list;
    }

    public void separateOddAndEvenList(List<StringBuilder> list) {

        List<StringBuilder> listWithOddValues = new ArrayList<>();
        List<StringBuilder> listWithEvenValues = new ArrayList<>();
        StringBuilder separator = new StringBuilder("-");

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() % 2 == 0) {
                listWithEvenValues.add(list.get(i));
            } else {
                listWithOddValues.add(list.get(i));
            }
        }

        while(separator.length() < 30) {
            separator.append(separator);
        }

        System.out.println("\nLISTA LITEREK PARZYSTYCH:");
        for (StringBuilder evenList : listWithEvenValues) {
            System.out.println(evenList + " " + evenList.length());
        }
        System.out.println("LICZBA ELEMENTOW = " + listWithEvenValues.size() + "\n" + separator);

        System.out.println("\nLISTA LITEREK NIEPARZYSTYCH:");
        for (StringBuilder oddList : listWithOddValues) {
            System.out.println(oddList + " " + oddList.length());
        }
        System.out.println("LICZBA ELEMENTOW = " + listWithOddValues.size() + "\n" + separator);

    }
}
