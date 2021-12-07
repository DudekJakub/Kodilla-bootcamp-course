package com.kodilla.patterns.library;

import com.kodilla.patterns.prototype.Prototype;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype<Library> {

    String name;
    Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Library: " + name +
                " -> list:\n" + books +
                "\n";
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedBoard = super.clone();
        clonedBoard.books = new HashSet<>();
        for (Book bookList : books) {
           Book clonedList = new Book(bookList.getTitle(), bookList.getAuthor(), bookList.getPublicationDate());
           clonedBoard.getBooks().add(clonedList);
        }
        return clonedBoard;
    }
}
