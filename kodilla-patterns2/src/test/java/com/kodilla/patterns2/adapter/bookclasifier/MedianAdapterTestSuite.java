package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.libraryA.Book;
import com.kodilla.patterns2.adapter.bookclasifier.libraryB.Statistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
public class MedianAdapterTestSuite {

    @Autowired
    Statistics statistics;

    @Autowired
    MedianAdapter medianAdapter;

    Book book1;
    Book book2;
    Book book3;
    Set<Book> bookSet = new HashSet<>();

    private void addMultipleBooksToCollection(Book... books) {
        bookSet.addAll(List.of(books));
    }

    @BeforeEach
    public void startSettings() {
        book1 = Book.builder()
                .author("Jakub Dudek")
                .title("How to become good programmer!")
                .publicationYear(2022)
                .signature("0001")
                .build();

        book2 = Book.builder()
                .author("Tolkien")
                .title("Lord of the Rings")
                .publicationYear(1968)
                .signature("0002")
                .build();

        book3 = Book.builder()
                .author("Tolkien")
                .title("The Hobbit")
                .publicationYear(1954)
                .signature("0003")
                .build();

       addMultipleBooksToCollection(book1, book2, book3);
    }

    @Test
    public void testAddMultipleBooksToCollection() {
        //Given & When
            //startSettings()

        //Then
        System.out.println(bookSet);

        assertEquals(3, bookSet.size());
        assertTrue(bookSet.contains(book1));
    }

    @Test
    public void testMedianAdapterForOddCollection() throws Exception {
        //Given
            //startSettings()

        //When
        double medianPublicationYearResult = medianAdapter.publicationYearMedian(bookSet);

        //Then
        assertEquals(book2.getPublicationYear(), medianPublicationYearResult);
    }

    @Test
    public void testMedianAdapterForEvenCollection() throws Exception {
        //Given
            //startSettings()

        //When
        List<Book> bookList = new ArrayList<>(bookSet);
        bookList.sort((o1, o2) -> o2.getPublicationYear() - o1.getPublicationYear());
        bookSet.remove(bookList.get(bookList.size()-1));

        double medianPublicationYearResult = medianAdapter.publicationYearMedian(bookSet);

        //Then
        assertEquals(1995, medianPublicationYearResult);
    }
}
