package com.kodilla.testing.library;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Book Directory Test Suite: begin \n");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Book Directory Test Suite: end \n-------------");
    }

    @BeforeEach
    public void before() {
        System.out.println("Book Directory Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Book Directory Test Case: end\n");
    }

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @Nested
    @DisplayName("Tests for lists with conditions")
    class TestListWithConditions {

        @Test
        void testListBooksWithConditionsReturnList() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOfBooks = new ArrayList<>();
            Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
            Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
            Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
            Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
            resultListOfBooks.add(book1);
            resultListOfBooks.add(book2);
            resultListOfBooks.add(book3);
            resultListOfBooks.add(book4);
            when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

            //When
            List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

            //Then
            assertEquals(4, theListOfBooks.size());
        }

        @Test
        void testListBooksWithConditionMoreThen20() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf0Books = new ArrayList<Book>();
            List<Book> resultListOf15Books = generateListOfNBooks(15);
            List<Book> resultListOf40Books = generateListOfNBooks(40);
            when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
            when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
            when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);

            //When
            List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
            List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
            List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

            //Then
            assertEquals(0, theListOfBooks0.size());
            assertEquals(15, theListOfBooks15.size());
            assertEquals(0,theListOfBooks40.size());
        }

        @Test
        void testListBooksWithConditionFragmentShorterThen3() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

            //When
            List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

            //Then
            assertEquals(0, theListOfBooks10.size());
            verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
        }
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title" + n, "Author" + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Nested
    @DisplayName("Tests for lists with rented books")
    class TestListWithRentedBooks {

        @Test
        void testListBooksInHandsWith0Books() {
            //Given
            LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

            LibraryUser libraryUser = new LibraryUser("Jakub", "Dudek", "940617");
            List<Book> resultListWith0Books = generateListOfNBooks(0);

            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListWith0Books);

            //When
            List<Book> theListOfRentedBooks = bookLibrary.listBooksInHandsOfBookLibrary(libraryUser);

            //Then
            assertEquals(0, theListOfRentedBooks.size());
        }

        @Test
        void testListBooksInHandsWith1Book() {
            //Given
            LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

            LibraryUser libraryUser = new LibraryUser("Dawid", "Kownacki", "930928");
            List<Book> resultListWith1Book = generateListOfNBooks(2);

            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListWith1Book);

            //When
            List<Book> theListOfRentedBooks = bookLibrary.listBooksInHandsOfBookLibrary(libraryUser);

            //Then
            assertEquals(2, theListOfRentedBooks.size());
        }

        @Test
        void testListBooksInHandsWith5Books() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

            LibraryUser libraryUser = new LibraryUser("Mateusz", "Kowalski", "891220");
            List<Book> resultListWith5Books = new ArrayList<Book>();
            resultListWith5Books.add(new Book("Title1", "Author1", 1970));
            resultListWith5Books.add(new Book("Title2", "Author2", 1971));
            resultListWith5Books.add(new Book("Title3", "Author3", 1972));
            resultListWith5Books.add(new Book("Title4", "Author4", 1973));
            resultListWith5Books.add(new Book("Title5", "Author5", 1974));


            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListWith5Books);

            //When
            List<Book> theListOfRentedBooks = bookLibrary.listBooksInHandsOfBookLibrary(libraryUser);

            //Then
            assertEquals(5, theListOfRentedBooks.size());
        }
    }

    @Nested
    @DisplayName("Test for va banque")
    class TestListWithBothMethods {

        @Test
        void testListBooksBothMethods() {
            //Given
            LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser libraryUser = new LibraryUser("Martyna", "Bykowska", "930728");

            Book book1 = new Book("The Lord of The Rings", "JRR Tolkien", 1958);
            Book book2 = new Book("The Hobbit", "JRR Tolkien", 1964);
            Book book3 = new Book("The Shining", "Stephen King", 1978);

            List<Book> resultListWith3Books = new ArrayList<Book>();
            resultListWith3Books.add(0, book1);
            resultListWith3Books.add(1, book2);
            resultListWith3Books.add(2, book3);

            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListWith3Books);
            when(libraryDatabaseMock.listBooksWithCondition("Lord")).thenReturn(Collections.singletonList(resultListWith3Books.get(0)));
            when(libraryDatabaseMock.listBooksWithCondition("Hobb")).thenReturn(Collections.singletonList(resultListWith3Books.get(1)));
            when(libraryDatabaseMock.listBooksWithCondition("Shin")).thenReturn(Collections.singletonList(resultListWith3Books.get(2)));

            //When
            List<Book> theListOfRentedBooks = bookLibrary.listBooksInHandsOfBookLibrary(libraryUser);
            List<Book> theListOfBooks1 = bookLibrary.listBooksWithCondition("Lord");
            List<Book> theListOfBooks2 = bookLibrary.listBooksWithCondition("Hobb");
            List<Book> theListOfBooks3 = bookLibrary.listBooksWithCondition("Shin");
            List<Book> theListOfBooks4 = bookLibrary.listBooksWithCondition("Th");

            //Then
            assertEquals(3, theListOfRentedBooks.size());
            assertEquals(Collections.singletonList(resultListWith3Books.get(0)), theListOfBooks1);
            assertEquals(Collections.singletonList(resultListWith3Books.get(1)), theListOfBooks2);
            assertEquals(Collections.singletonList(resultListWith3Books.get(2)), theListOfBooks3);
            assertEquals(0, theListOfBooks4.size());
        }
    }
}


