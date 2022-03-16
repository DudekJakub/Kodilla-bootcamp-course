package com.kodilla.patterns2.adapter.bookclasifier.libraryA;

import java.util.Set;

public interface Classifier {
    double publicationYearMedian(Set<Book> bookSet) throws Exception;
}
