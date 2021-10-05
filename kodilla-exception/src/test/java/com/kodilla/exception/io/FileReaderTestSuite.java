package com.kodilla.exception.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTestSuite {

    @Test
    void testReadFile() {
        //Given
        FileReader fileReader = new FileReader();

        //When & Then
        assertDoesNotThrow(() -> fileReader.readFile());
    }

    @Test
    void testReadFileWhenFileDoesntExists() {
        //Given
        FileReader fileReader = new FileReader();
        String fileName = "nie_ma_takiego_pliku.txt";

        //When & Then
        Assertions.assertThrows(FileReaderException.class, () -> fileReader.readFile2(fileName));
    }

    @Test
    void testReadFileWithName() {
        //Given
        FileReader fileReader = new FileReader();
        String fileName = "nie_ma_takiego_pliku.txt";

        //When & Then
        assertAll(
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile2(fileName)),
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile2(null)),
                () -> assertDoesNotThrow(() -> fileReader.readFile2("names.txt"))
        );
    }
}
