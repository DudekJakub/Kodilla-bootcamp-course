package com.kodilla.patterns2.adapter.bookclasifier.libraryB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

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
}
