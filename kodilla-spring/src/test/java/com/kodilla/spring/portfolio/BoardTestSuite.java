package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        board.getToDoList().tasks.add("Something to do...");
        board.getInProgressList().tasks.add("Something in progress...");
        board.getDoneList().tasks.add("Done stuff!");

        //Then
        Assertions.assertEquals("Something to do...", board.getToDoList().tasks.get(0));
        Assertions.assertEquals("Something in progress...", board.getInProgressList().tasks.get(0));
        Assertions.assertEquals("Done stuff!", board.getDoneList().tasks.get(0));

        System.out.println(board.getDoneList().tasks.get(0));
        System.out.println(board.getInProgressList().tasks.get(0));
        System.out.println(board.getDoneList().tasks.get(0));
    }
}
