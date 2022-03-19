package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.libraryB.Book;
import com.kodilla.patterns2.adapter.bookclasifier.libraryB.BookSignature;
import com.kodilla.patterns2.adapter.bookclasifier.libraryB.Statistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StatisticsTestSuite {

    @Autowired
    Statistics statistics;

    Book book1;
    Book book2;
    Book book3;
    HashMap<BookSignature, Book> books = new HashMap<>();

    @BeforeEach
    public void startSettings() {
        book1 = Book.builder()
                .author("Jakub Dudek")
                .title("How to become good programmer!")
                .publicationYear(2022)
                .build();

        book2 = Book.builder()
                .author("Tolkien")
                .title("Lord of the Rings")
                .publicationYear(1968)
                .build();

        book3 = Book.builder()
                .author("Tolkien")
                .title("The Hobbit")
                .publicationYear(1954)
                .build();

        books.put(new BookSignature("0001"), book1);
        books.put(new BookSignature("0002"), book2);
        books.put(new BookSignature("0003"), book3);
    }

    @Test
    public void testAveragePublicationYear() {
        //Given
            //startSettings()

        //When
        int averagePublicationYearResult = statistics.averagePublicationYear(books);

        //Then
        assertEquals((book1.getPublicationYear() + book2.getPublicationYear() + book3.getPublicationYear())/3, averagePublicationYearResult);
    }

    @Test
    public void testMedianPublicationYear() throws Exception {
        //Given
            //startSettings()

        //When
        double medianPublicationYearResult = statistics.medianPublicationYear(books);

        //Then
        assertEquals(book2.getPublicationYear(), medianPublicationYearResult);
    }

    @Test
    public void testModaSimpleArray() {
        //Given
        ArrayList<Integer> numbers = new ArrayList<Integer>(4);
        for (int i = 1; i < 5; i++) {
            numbers.add(i);
            if (i == 3) {
                numbers.add(i);
            }
        }
        numbers.add(4);
        numbers.add(4);
        numbers.add(5);
        numbers.add(5);
        numbers.add(5);
        numbers.add(5);
        System.out.println(numbers);

        //When
            int var1 = 0;
            int var2 = 1;
            int result = 0;

            for (int i = 0; i < numbers.size(); i++) {
                for (int j = 0; j < numbers.size(); j++) {
                    if (Objects.equals(numbers.get(i), numbers.get(j))) {
                        var1++;
                        if (var1 >= var2) {
                            var2 = var1;
                            result = numbers.get(j);
                        }
                    }
                }
                var1 = 0;
            }
            System.out.println(result);

        //Then
        assertEquals(5, result);
        }
}
