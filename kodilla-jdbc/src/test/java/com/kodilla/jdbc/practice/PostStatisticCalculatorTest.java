package com.kodilla.jdbc.practice;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

@SpringBootTest(classes = {PostConfiguration.class})
class PostStatisticCalculatorTest {

    private static PostStatisticCalculator postStatisticCalculator;

    @BeforeAll
    static void setBeansForTests() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PostConfiguration.class);
        postStatisticCalculator = applicationContext.getBean(PostStatisticCalculator.class);
    }

    @Test
    void calculateQuantityOfUsersPostsPerMonth() throws SQLException {
        postStatisticCalculator.calculateQuantityOfUsersPostsPerMonth();
    }
}