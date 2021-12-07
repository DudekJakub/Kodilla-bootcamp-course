package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    static void creatingLog() {
        logger = Logger.INSTANCE;
        logger.log("Some log-message here...");
    }

    @Test
    void testGetLastLog() {
        //Given
        //When
        String lastLog = Logger.INSTANCE.getLastLog();

        //Then
        Assertions.assertEquals("Some log-message here...", lastLog);
    }
}
