package com.kodilla.patterns2.adapter.bookclasifier.libraryB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Statistics implements BookStatistics {

    final static private Logger LOGGER = LoggerFactory.getLogger(Statistics.class);

    @Override
    public int averagePublicationYear(Map<BookSignature, Book> books) {
        LOGGER.info("Start counting...");

        int averageResult = 0;
        for (Map.Entry<BookSignature, Book> bookMap : books.entrySet()) {
            averageResult = averageResult + bookMap.getValue().getPublicationYear();
        }
        averageResult = averageResult/books.size();

        System.out.println("Result = " + averageResult);
        LOGGER.info("Counting finished!");
        return averageResult;
    }

    @Override
    public double medianPublicationYear(Map<BookSignature, Book> books) throws Exception {
        LOGGER.info("Start searching for median...");

        double medianResult = 0.0;
        List<Integer> yearsList = new ArrayList<>();
        for (Map.Entry<BookSignature, Book> bookMap : books.entrySet()) {
            yearsList.add(bookMap.getValue().getPublicationYear());
        }
        yearsList.sort(Comparator.naturalOrder());

        if (yearsList.size() % 2 != 0) {
            medianResult = yearsList.get(yearsList.size()/2);
        } else {
            medianResult = (double) (yearsList.get(yearsList.size()/2) + yearsList.get(yearsList.size()/2-1))/2;

            System.out.println("Pierwsza liczba : " + yearsList.get(yearsList.size()/2) + "\n" +
                               "Druga liczba : " + yearsList.get(yearsList.size()/2-1));
        }

        System.out.println("Result = " + medianResult);
        LOGGER.info("Searching finished!");
        return medianResult;
    }

    @Override
    public List<Integer> modePublicationYear(Map<BookSignature, Book> books) {
        LOGGER.info("Start searching for mode...");

        int var1;
        int var2 = 1;
        int var3 = 0;
        int result;

        List<Integer> yearsList = new ArrayList<>();
        for (Map.Entry<BookSignature, Book> bookEntry : books.entrySet()) {
            yearsList.add(bookEntry.getValue().getPublicationYear());
        }

        Map<Integer, Integer> multipleModesInit = new HashMap<>();
        List<Integer> repeatListOfYears = new ArrayList<>();

        yearsList.sort(Comparator.naturalOrder());
        System.out.println(yearsList);

        for (int i = 0; i < yearsList.size(); i++) {
            var1 = 0;
            var2 = 0;
            for (int j = 0; j < yearsList.size(); j++) {
                if (yearsList.get(i).intValue() == yearsList.get(j).intValue()) {
                    var1++;
                    if (var1 >= var2) {
                        var2 = var1;
                        repeatListOfYears.add(var2);
                        result = yearsList.get(i);
                        var3++;
                        System.out.println(result + " -> kolejność: " +var3);
                        if (var2 > 1) {
                            multipleModesInit.put(result, var2);
                        }
                    }
                }
            }
        }
        System.out.println("Initial = " + multipleModesInit);

        repeatListOfYears.sort(Comparator.naturalOrder());
        var2 = repeatListOfYears.get(repeatListOfYears.size()-1);
        System.out.println("Highest number of repeats = " + var2);

        int finalVar = var2;
        Map<Integer, Integer> multipleModesSorted = multipleModesInit
                .entrySet()
                .stream()
                .filter(year -> year.getValue() == finalVar)
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println("Sorted = " + multipleModesSorted);

        if (multipleModesSorted.size() > 1) {
            System.out.println("Collection includes multiple modes: " + multipleModesSorted.keySet() + ". Modes repetition = " + multipleModesSorted.values().stream().findFirst().get());
        } else {
            System.out.println("Collection includes one mode: " + multipleModesSorted.keySet() + ". Mode repetition = " + multipleModesSorted.values().stream().findFirst().get());
        }
        LOGGER.info("Searching finished!");
        return new ArrayList<>(multipleModesSorted.keySet());
    }
}
