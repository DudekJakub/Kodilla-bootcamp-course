package com.kodilla.jdbc.practice;

import com.kodilla.jdbc.DbManager;
import groovy.util.MapEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PostsEntityProcessorTest {

    PostsEntityProcessor postsEntityProcessor = new PostsEntityProcessor();

    @Test
    void measureQuantityOfPostsForUsers() throws SQLException {
        //Given
        int userId = 1;

        //When
        int result = postsEntityProcessor.measureQuantityOfPostsForUsers(userId);

        //Then
        assertEquals(3, result);
    }

    @Test
    void getRandomDayForPost() {
        //Given
        //When
        int result = postsEntityProcessor.getRandomDayForPost();

        //Then
        System.out.println(result);

        assertTrue(result < LocalDate.now().getDayOfYear());
        assertTrue(result > 0);
    }

    @Test
    void addPostWithRandomizedDateOfPost() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        int userId = 1;
        String postBody = "'Testing addRandomizedDatesOfPosts'";

        int userPostsQuantityBeforeAddPost = postsEntityProcessor.measureQuantityOfPostsForUsers(userId);

        //When
        postsEntityProcessor.addPostWithRandomizedDateOfPost(userId, postBody);

        //Then
        String selectSQL = "SELECT body, date_of_post FROM kodilla_course.posts WHERE USER_ID = 1";

        Statement statement = dbManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(selectSQL);

        Map<String, LocalDate> bodyAndDatesOfPostsAfterAddNewRow = new HashMap<>();

        resultSet.next();

        String firstBody = resultSet.getString("BODY");
        Date firstDateOfPost = resultSet.getDate("date_of_post");
        bodyAndDatesOfPostsAfterAddNewRow.put(firstBody, firstDateOfPost.toLocalDate());

        while (resultSet.next()) {
               String nextPostBody = resultSet.getString("BODY");
               Date nextDateOfPost = resultSet.getDate("date_of_post");
               bodyAndDatesOfPostsAfterAddNewRow.put(nextPostBody, nextDateOfPost.toLocalDate());
        }

        statement.close();
        resultSet.close();

        for (Map.Entry<String, LocalDate> set : bodyAndDatesOfPostsAfterAddNewRow.entrySet()) {
            System.out.println("POST_BODY: " + set.getKey() + " | CREATION_DATE: " + set.getValue());
        }

        assertEquals(3, userPostsQuantityBeforeAddPost);
        assertEquals(4, bodyAndDatesOfPostsAfterAddNewRow.size());

        //CleanUp
        String sql_DELETE = "DELETE FROM kodilla_course.posts WHERE BODY = " + postBody;
        Statement statement1 = dbManager.getConnection().createStatement();
        statement1.executeUpdate(sql_DELETE);
        statement1.close();
    }

    @Test
    void getAllUserPostsWithDates() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        int userId = 1;
        int resultSetNextCounter = 0;
        String sql_SELECT = "SELECT body, date_of_post FROM kodilla_course.posts WHERE user_id = 1";
        String sql_SELECT_getUserFirstname = "SELECT firstname FROM kodilla_course.users WHERE id = " + userId;
        String sql_SELECT_getUserLastname = "SELECT lastname FROM kodilla_course.users WHERE id = " + userId;

        //When
        Map<String, LocalDate> mapResult = postsEntityProcessor.getAllUserPostsWithDates(userId);

        //Then
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rS = statement.executeQuery(sql_SELECT);

        Statement statement1 = dbManager.getConnection().createStatement();
        ResultSet userFIRSTNAME = statement1.executeQuery(sql_SELECT_getUserFirstname);

        Statement statement2 = dbManager.getConnection().createStatement();
        ResultSet userLASTNAME = statement2.executeQuery(sql_SELECT_getUserLastname);

        rS.next();
        resultSetNextCounter++;

        while (rS.next()) {
            resultSetNextCounter++;
        }

        statement.close();
        rS.close();

        userFIRSTNAME.next();
        userLASTNAME.next();
        System.out.println("List of posts and their creation_date of specific USER: (userID) " + userId
                            + " (" + userFIRSTNAME.getString("FIRSTNAME") + " " + userLASTNAME.getString("LASTNAME") + ")");

        statement1.close();
        userFIRSTNAME.close();
        statement2.close();
        userLASTNAME.close();

        for (Map.Entry<String, LocalDate> set : mapResult.entrySet()) {
            System.out.println("POST_BODY: " + set.getKey() + " | CREATION_DATE: " + set.getValue());
        }

        assertEquals(resultSetNextCounter, mapResult.size());
    }

    @Test
    void changeAllRoundedDatesOfPostsToRandom() throws SQLException {
        //Given
        //When
        int rowsAffectedQuantity = postsEntityProcessor.changeAllRoundedDatesOfPostsToRandom();

        //Then
        assertEquals(12, rowsAffectedQuantity);
    }
}