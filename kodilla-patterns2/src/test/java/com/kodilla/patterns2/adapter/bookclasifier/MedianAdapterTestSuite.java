package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.libraryA.Book;
import com.kodilla.patterns2.adapter.bookclasifier.libraryB.BookSignature;
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

    @Test
    public void testMultipleModesForPublicationYear() {
        //Given
            //startSettings()
            // +

        Book book4 = Book.builder().publicationYear(1977).build();
        Book book5 = Book.builder().publicationYear(1977).build();
        Book book6 = Book.builder().publicationYear(1977).build();
        Book book7 = Book.builder().publicationYear(1968).build();
        Book book8 = Book.builder().publicationYear(1968).build();

        bookSet.add(book4);
        bookSet.add(book5);
        bookSet.add(book6);
        bookSet.add(book7);
        bookSet.add(book8);


        //When
        List<Integer> multipleModesResult = medianAdapter.publicationYearModa(bookSet);

        //Then
        List<Integer> assertIntegersList = new ArrayList<>();
        assertIntegersList.add(1968);
        assertIntegersList.add(1977);

        assertEquals(assertIntegersList, multipleModesResult);
    }

    @Test
    public void testOneModeForPublicationYear() {
        //Given
            //startSettings()
            // +

        Book book4 = Book.builder().publicationYear(2022).build();

        bookSet.add(book4);

        //When
        List<Integer> oneModeResult = medianAdapter.publicationYearModa(bookSet);

        //Then
        int[] array = new int[]{2022};

        assertEquals(Arrays.stream(array).boxed().collect(Collectors.toList()), oneModeResult);
    }

    @Test
    public void testModePublicationStreamWithStream() {
        //Given
        Map<BookSignature, com.kodilla.patterns2.adapter.bookclasifier.libraryB.Book> books = new HashMap<>();
        BookSignature bookSignature = new BookSignature("10201");
        BookSignature bookSignature2 = new BookSignature("10321");
        BookSignature bookSignature3 = new BookSignature("10322");
        BookSignature bookSignature4 = new BookSignature("1032324");

        com.kodilla.patterns2.adapter.bookclasifier.libraryB.Book book = new com.kodilla.patterns2.adapter.bookclasifier.libraryB.Book("b", "a", 2000);
        com.kodilla.patterns2.adapter.bookclasifier.libraryB.Book book1 = new com.kodilla.patterns2.adapter.bookclasifier.libraryB.Book("b", "a", 2000);
        com.kodilla.patterns2.adapter.bookclasifier.libraryB.Book book2 = new com.kodilla.patterns2.adapter.bookclasifier.libraryB.Book("b", "a", 2001);
        com.kodilla.patterns2.adapter.bookclasifier.libraryB.Book book3 = new com.kodilla.patterns2.adapter.bookclasifier.libraryB.Book("b", "a", 2002);

        books.put(bookSignature, book);
        books.put(bookSignature2, book1);
        books.put(bookSignature3, book2);
        books.put(bookSignature4, book3);

        //When
        var result = statistics.modePublicationYearWithStream(books);

        System.out.println(result);
    }

    @Test
    public void testImmutable() {
        //Given

    }
}
