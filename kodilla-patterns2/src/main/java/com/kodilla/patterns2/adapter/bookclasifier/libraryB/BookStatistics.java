package com.kodilla.patterns2.adapter.bookclasifier.libraryB;

import java.util.List;
import java.util.Map;

public interface BookStatistics {
    int averagePublicationYear(Map<BookSignature, Book> books);
    double medianPublicationYear(Map<BookSignature, Book> books) throws Exception;
    List<Integer> modePublicationYear(Map<BookSignature, Book> books);
}
