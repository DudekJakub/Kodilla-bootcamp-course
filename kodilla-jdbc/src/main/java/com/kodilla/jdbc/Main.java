package com.kodilla.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Main {

    private static String selectFrom= "SELECT * FROM ";

    public static void main(String[] args) {

        try {
        int counter = 0;
            ResultSet result = QueryExecutorSQL.executeSelect(selectFrom + "USERS");
            result.next();
            String userFirstNameFirst = result.getString("FIRSTNAME");
            String userLastNameFirst = result.getString("LASTNAME");
            System.out.println(userFirstNameFirst + " " + userLastNameFirst);

            while (counter < result.getString("FIRSTNAME").length()) {
                counter++;
                result.next();
                String userFirstNameNext = result.getString("FIRSTNAME");
                String userLastNameNext = result.getString("LASTNAME");
                System.out.println(userFirstNameNext + " " + userLastNameNext);
            }

            while (result.next()) {
                String userFirstNameNext = result.getString("FIRSTNAME");
                String userLastNameNext = result.getString("LASTNAME");
                String userID = result.getString("ID");
                System.out.println(userID + " | " + userFirstNameNext + " " + userLastNameNext);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        String INSERT_SQL = "INSERT INTO users " + "VALUES(7,'Martyna','Dudek')";
//        QueryExecutorSQL.executeQuery(INSERT_SQL);

        String UPDATE_SQL = "UPDATE USERS SET FIRSTNAME='Jakub' WHERE ID=6";
        QueryExecutorSQL.executeQuery(UPDATE_SQL);

        String tableName = "posts";
        QueryExecutorSQL.checkIfTableExists(tableName);

//        String DELETE_SQL = "DELETE FROM users " + "WHERE ID = 5";
//        QueryExecutorSQL.executeQuery(DELETE_SQL);

        String selectQuery = "SELECT * FROM users WHERE FIRSTNAME = 'Jakub'";
        ResultSet resultForFirstname = QueryExecutorSQL.executeSelect(selectQuery);
        try {
            resultForFirstname.next();
            String userLastname = resultForFirstname.getString("LASTNAME");
            System.out.println(userLastname);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        String testTableName = "Test_Table";
        QueryExecutorSQL.createNewTableIfDoesntAlreadyExist(testTableName,
                " (ID bigint unsigned auto_increment primary key, TEST_COLUMN varchar(100) null)");

        String tableNameToDROP = "test_table";
        QueryExecutorSQL.dropTable(tableNameToDROP);

        String selectFromUser = "SELECT * FROM USERS";
        String selectFromPosts = "SELECT * FROM posts";
        ResultSet resultFromUser = QueryExecutorSQL.executeSelect(selectFromUser);
        ResultSet resultFromPost = QueryExecutorSQL.executeSelect(selectFromPosts);

        try {
            int counter = 0;
            resultFromUser.next();
            System.out.println(resultFromUser.getString("FIRSTNAME"));

            do {
                counter++;

                resultFromUser.next();
                String userID = resultFromUser.getString("FIRSTNAME");
                System.out.println(userID);
            } while (counter < resultFromUser.getString("FIRSTNAME").length());

            resultFromUser.next();
            System.out.println(resultFromUser.getString("FIRSTNAME"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
