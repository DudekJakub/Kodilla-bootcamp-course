package com.kodilla.hibernate.task.dal_with_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public enum DbManager {

    INSTANCE;

    private final Connection conn;

    DbManager() {
        Properties properties = new Properties();
        properties.put("user", "kodilla-user");
        properties.put("password", "kodilla_Pass123");
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" +
                        "kodilla_course?serverTimezone=Europe/Warsaw" +
                        "&useSSL=False&allowPublicKeyRetrieval=true",
                    properties);
        } catch (SQLException e) {
            throw new ExceptionInInitializerError(e.getSQLState());
        }
    }

    public static DbManager getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return conn;
    }
}
