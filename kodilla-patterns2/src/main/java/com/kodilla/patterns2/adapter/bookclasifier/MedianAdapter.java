package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.libraryA.Book;
import com.kodilla.patterns2.adapter.bookclasifier.libraryA.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryB.BookSignature;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class MedianAdapter extends MedianAdaptee implements Classifier {

    @Override
    public double publicationYearMedian(Set<Book> bookSet) throws Exception {
        Map<BookSignature, com.kodilla.patterns2.adapter.bookclasifier.libraryB.Book> bookMap = new HashMap<>();
        for (Book book : bookSet) {
            bookMap.put(new BookSignature(""), new com.kodilla.patterns2.adapter.bookclasifier.libraryB.Book(book.getAuthor(), book.getTitle(), book.getPublicationYear()));
        }
        return medianPublicationYear(bookMap);
    }
}
