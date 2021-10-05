package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;

public class ExceptionModuleRunner {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();

        try {
            fileReader.readFile();
        } catch (FileReaderException e) {
            System.out.println("Oh no! Something went wrong!");
        }


        try {
            fileReader.readFile2("names.txt");
        } catch (FileReaderException e) {
            System.out.println("Oh no! There is no such a file!");
        }
    }
}
