package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.library.Book;
import com.kodilla.patterns.library.Library;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given
        Library library = new Library("Academic Library");
        Book lotr = new Book("The Lord of the Rings", "JRR Tolkien", LocalDate.of(1957, 6, 17));
        Book hPotter = new Book("Harry Potter [part_1]", "Rowling", LocalDate.of(1994, 7, 17));
        Book aliceInWonder = new Book("Alice in Wonderland", "Lewis Carroll", LocalDate.of(1865, 04, 10));

        //When
        library.getBooks().add(lotr);
        library.getBooks().add(hPotter);
        library.getBooks().add(aliceInWonder);


        //making shallowCopy of library
        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("Academic Library [shallowCopy]");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //making deepCopy of library
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Academic Library [deepCopy]");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //removing one book
        library.getBooks().remove(lotr);

        //Then
        System.out.println(library);
        System.out.println(shallowClonedLibrary);
        System.out.println(deepClonedLibrary);

        Assertions.assertEquals(2, library.getBooks().size());
        Assertions.assertEquals(2, shallowClonedLibrary.getBooks().size()); // płytnie klonowanie uwzględnia usunięcie książki z pierwotnej biblioteki!
        Assertions.assertEquals(3, deepClonedLibrary.getBooks().size()); // głębokie klonowanie tworzy nową instancję hashSetu ze
                                                                                 // sklonowanymi obiektami książek i tym samym w pamięci komputera jest to nowa hashMapa!
        Assertions.assertEquals(shallowClonedLibrary.getBooks(), library.getBooks());
        Assertions.assertNotEquals(deepClonedLibrary.getBooks(), library.getBooks());
    }
}
