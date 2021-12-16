package com.kodilla.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main extends QueryExecutorSQL {

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
