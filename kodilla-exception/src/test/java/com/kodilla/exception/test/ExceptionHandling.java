package com.kodilla.exception.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionHandling {

    @BeforeEach
    void beforeEach() {
        System.out.println("Exception Handling Test Case: begin");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Exception Handling Test Case: end");
    }

    @Test
    void testProbablyIWillThrowException() {
        //Given
        SecondChallenge challenge = new SecondChallenge();

        //When & Then
        Assertions.assertAll(
                () -> assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(22,1.5)),
                () -> assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(0, 0)),
                () -> assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(0.9,1.6)),
                () -> assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(1.9, 1.5)),
                () -> assertDoesNotThrow(() -> challenge.probablyIWillThrowException(1.9, 1.4)),
                () -> assertDoesNotThrow(() -> challenge.probablyIWillThrowException(1,2))
        );
    }

    public void handlingExceptionFromSecondChallengeMethod() {
        SecondChallenge challenge = new SecondChallenge();

        try {
            System.out.println("Testing method...");
            System.out.println(challenge.probablyIWillThrowException(1, 2));
        } catch (Exception e) {
            System.out.println("Exception has been caught!");
        } finally {
            System.out.println("Static information block.");
        }
    }

    public static void main (String[] args) {
        ExceptionHandling eH = new ExceptionHandling();
        eH.handlingExceptionFromSecondChallengeMethod();

        System.out.println("-------");

        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            System.out.println("Testing method...");
            System.out.println(secondChallenge.probablyIWillThrowException(1,2));;
        } catch (Exception e) {
            System.out.println("Exception has been caught!");
        } finally {
            System.out.println("Static information block. Will always be here.");
        }
    }
}
