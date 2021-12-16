package com.kodilla.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryExecutorSQL {

    private static Connection connection;
    private static Statement statement;

    public static ResultSet executeSelect(String selectQuery) {

        try {
            connection = DbManager.getInstance().getConnection();
            statement = connection.createStatement();
            return statement.executeQuery(selectQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void executeQuery(String query) {

        try {
            connection = DbManager.getInstance().getConnection();
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
