package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.libraryB.Book;
import com.kodilla.patterns2.adapter.bookclasifier.libraryB.BookSignature;
import com.kodilla.patterns2.adapter.bookclasifier.libraryB.BookStatistics;
import com.kodilla.patterns2.adapter.bookclasifier.libraryB.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MedianAdaptee implements BookStatistics {

    @Autowired
    Statistics statistics;

    @Override
    public int averagePublicationYear(Map<BookSignature, Book> books) {
        return statistics.averagePublicationYear(books);
    }

    @Override
    public double medianPublicationYear(Map<BookSignature, Book> books) throws Exception {
        return statistics.medianPublicationYear(books);
    }
}
