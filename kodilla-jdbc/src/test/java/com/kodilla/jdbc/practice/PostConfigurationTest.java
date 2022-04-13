package com.kodilla.jdbc.practice;

import com.kodilla.jdbc.DbManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest(classes = {PostConfiguration.class})
class PostConfigurationTest {

    @Autowired
    PostConfiguration postConfiguration;

    @Test
    void testApplicationContext() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.kodilla.jdbc");

        PostConfiguration postConfiguration = applicationContext.getBean(PostConfiguration.class);
        System.out.println(postConfiguration);

        DbManager dbManager = applicationContext.getBean(DbManager.class);
        System.out.println(dbManager);

        System.out.println(dbManager.getConnection());
    }
}