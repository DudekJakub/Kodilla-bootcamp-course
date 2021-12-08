package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskFactoryTestSuite {

    private TaskFactory factory;

    @BeforeEach
    void createNewFactory() {
        factory = new TaskFactory();
    }

    @Test
    void testFactoryShopping() {
        //Given
        //When
        Task shopping = factory.makeTask(TaskFactory.SHOPPING_TASK);
        shopping.executeTask();

        //Then
        Assertions.assertEquals("SHOPPING", shopping.getTaskName());
        Assertions.assertTrue(shopping.isTaskExecuted());
    }

    @Test
    void testFactoryPainting() {
        //Given
        //When
        Task painting = factory.makeTask(TaskFactory.PAINTING_TASK);
        painting.executeTask();

        //Then
        Assertions.assertEquals("PAINTING", painting.getTaskName());
        Assertions.assertTrue(painting.isTaskExecuted());
    }

    @Test
    void testFactoryDriving() {
        //Given
        //When
        Task driving = factory.makeTask(TaskFactory.DRIVING_TASK);
        driving.executeTask();

        //Then
        Assertions.assertEquals("DRIVING", driving.getTaskName());
        Assertions.assertTrue(driving.isTaskExecuted());
    }

}
