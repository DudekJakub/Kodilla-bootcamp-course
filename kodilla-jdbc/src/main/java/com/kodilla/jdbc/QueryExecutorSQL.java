package com.kodilla.jdbc;

import java.sql.*;

public class QueryExecutorSQL {

    private static Connection connection;
    private static Statement statement;

    public static ResultSet executeSelect(String selectQuery) {

        try {
            connection = DbManager.getInstance().getConnection();
            statement = connection.createStatement();
            System.out.println(statement.isClosed());
            return statement.executeQuery(selectQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void executeQuery(String query) {

        try {
            connection = DbManager.getInstance().getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static boolean checkIfTableExists(String tableName) {

        try {
            connection = DbManager.getInstance().getConnection();
            statement = connection.createStatement();
            DatabaseMetaData dbmd = connection.getMetaData();
            ResultSet rs = dbmd.getTables(null, null, tableName, null);

            System.out.println(rs.next());
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void createNewTableIfDoesntAlreadyExist(String tableName, String tableParameters) {

        try {
            connection = DbManager.getInstance().getConnection();
            statement = connection.createStatement();
            String createTable = "CREATE TABLE IF NOT EXISTS " + tableName + " " + tableParameters;
            statement.execute(createTable);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void addNewColumnToTable(String tableName, String columnName, String columnParameters) {

        try {
            connection = DbManager.getInstance().getConnection();
            statement = connection.createStatement();
            String addColumn = "ALTER TABLE " + tableName + " ADD COLUMN " + columnName + " " + columnParameters;
            statement.execute(addColumn);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void dropTable(String tableName) {

        try {
            connection = DbManager.getInstance().getConnection();
            statement = connection.createStatement();
            String dropTable = "DROP TABLE " + tableName;
            statement.execute(dropTable);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
