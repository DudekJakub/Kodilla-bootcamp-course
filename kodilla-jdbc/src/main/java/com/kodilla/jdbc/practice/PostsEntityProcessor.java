package com.kodilla.jdbc.practice;

import com.kodilla.jdbc.DbManager;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;

public class PostsEntityProcessor {

    public int measureQuantityOfPostsForUsers(int userId) throws SQLException {
        DbManager dbManager = DbManager.getInstance();

        String sql_SELECT = "SELECT * FROM kodilla_course.posts WHERE user_id = " + userId;

        Statement statement = dbManager.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rS = statement.executeQuery(sql_SELECT);

        rS.last();

        return rS.getRow();
    }

    public Map<String,LocalDate> getAllUserPostsWithDates(int userId) throws SQLException {
        DbManager dbManager = DbManager.getInstance();

        Map<String, LocalDate> allUserPostsWIthDates = new HashMap<>();

        String sql_SELECT = "SELECT body, date_of_post FROM kodilla_course.posts WHERE USER_ID = " + userId;

        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rS = statement.executeQuery(sql_SELECT);

        rS.next();
        String firstPostBody = rS.getString("BODY");
        Date firstPostDate = rS.getDate("date_of_post");
        allUserPostsWIthDates.put(firstPostBody, firstPostDate.toLocalDate());

        while (rS.next()) {
            String nextPostBody = rS.getString("BODY");
            Date nextPostDate = rS.getDate("date_of_post");
            allUserPostsWIthDates.put(nextPostBody, nextPostDate.toLocalDate());
        }

        return allUserPostsWIthDates;
    }

    public int getRandomDayForPost() {
        int dayRange = LocalDate.now().getDayOfYear();

        Random generateRandomDay = new Random();

        int result = generateRandomDay.nextInt(dayRange);
        if (result == 0) {
            return 1;
        }
        return result;
    }

    public void addPostWithRandomizedDateOfPost(int userId, String postBody) throws SQLException {
        DbManager dbManager = DbManager.getInstance();

        int yearRange = LocalDate.now().getYear();

        String sql_INSERT = "INSERT INTO kodilla_course.posts VALUE (null, " + userId + ", " + postBody + ", MAKEDATE(" + yearRange + ", " + getRandomDayForPost() + "))";

        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sql_INSERT);
    }

    public int changeAllRoundedDatesOfPostsToRandom() throws SQLException {
        DbManager dbManager = DbManager.getInstance();

        String sql_UPDATE = "UPDATE kodilla_course.posts SET date_of_post = CURRENT_DATE - INTERVAL FLOOR(RAND() * " + LocalDate.now().getDayOfYear() + ") DAY";

        Statement statement = dbManager.getConnection().createStatement();
        return statement.executeUpdate(sql_UPDATE);
    }
}
