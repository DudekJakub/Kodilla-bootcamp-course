package com.kodilla.jdbc;

import com.kodilla.jdbc.practice.PostConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Component
public class DbManager {

    private final Connection conn;

    public DbManager() {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "kodilla-user");
        connectionProps.put("password", "kodilla_Pass123");
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/kodilla_course" +
                         "?serverTimezone=Europe/Warsaw" +
                         "&useSSL=False" + "&zeroDateTimeBehavior=ROUND",
                          connectionProps);
        } catch (SQLException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static DbManager getInstance() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PostConfiguration.class);
        return applicationContext.getBean(DbManager.class);
    }

    public Connection getConnection() {
        return conn;
    }
}
