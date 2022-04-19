package com.kodilla.jdbc.practice;

import com.kodilla.jdbc.DbManager;
import org.mockito.cglib.core.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;

@Service
public class PostsEntityProcessor {

    private final DbManager dbManager;

    @Autowired
    public PostsEntityProcessor(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public int measureQuantityOfPostsForUsers(int userId) throws SQLException {
        String sql_SELECT = "SELECT * FROM kodilla_course.posts WHERE user_id = " + userId;

        Statement statement = dbManager.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rS = statement.executeQuery(sql_SELECT);
        rS.last();
        return rS.getRow();
    }

    public int countNumberOfRowsInTable(String tableName) throws SQLException {
        String sql_SELECT = "SELECT * FROM kodilla_course." + tableName;

        Statement statement = dbManager.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rS = statement.executeQuery(sql_SELECT);
        rS.last();
        return rS.getRow();
    }

    public Map<Integer, Integer> countNumberOfPostsForEveryUser() throws SQLException {
        String sql_SELECT = "SELECT USER_ID, COUNT(*) AS 'quantity' FROM kodilla_course.posts GROUP BY USER_ID";

        ResultSet resultSet = dbManager.getConnection().createStatement().executeQuery(sql_SELECT);
        Map<Integer,Integer> userWithPostQuantity = new HashMap<>();
        while (resultSet.next()) {
            userWithPostQuantity.put(resultSet.getInt(1), resultSet.getInt(2));
        }
        return userWithPostQuantity;
    }

    public Map<Integer, Map<String,LocalDate>> getAllUsersPostsAndDates() throws SQLException {
        String sql_SELECT_userIds = "SELECT p.user_id FROM kodilla_course.posts p ORDER BY p.USER_ID";
        String sql_SELECT_userPostsAndDates = "SELECT p.body, p.date_of_post FROM kodilla_course.posts p WHERE user_id = ";

        Map<Integer, Map<String, LocalDate>> mapWithUsersIds_and_assignedPostsWithDates = new HashMap<>();

        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rS = statement.executeQuery(sql_SELECT_userIds);
        rS.next();
        while (rS.next()) {
            mapWithUsersIds_and_assignedPostsWithDates.put(Integer.valueOf(rS.getString("user_id")), new HashMap<>());
        }
        rS.close();
        statement.close();

        var counter_UsersWithPostsSize = 1; //ilość użytkowników z postami
        var counter_UserPostsQuantity = 1; //ilość postów użytkownika

        Statement statement1 = dbManager.getConnection().createStatement();

        /** Pierwsza pętla wykonuje się tak długo, aż nie zostaną wykonane akcje dla wszystkich USERów
         *  Druga pętla wykonuje się tak długo, aż nie zostaną przeiterowane wszystkie wiersze z postami dla danego USERa
         *  Trzecia pętlka wykonuje się do momentu, aż kursor resultSeta będzie miał przed sobą kolejny wiersz
         */

        while (counter_UsersWithPostsSize <= mapWithUsersIds_and_assignedPostsWithDates.keySet().size()) {

            while (counter_UserPostsQuantity <= getAllUserPostsWithDates(counter_UsersWithPostsSize).values().size()) {
                ResultSet userPostsWithDates = statement1.executeQuery(sql_SELECT_userPostsAndDates + counter_UsersWithPostsSize);

                while (userPostsWithDates.next()) {
                        mapWithUsersIds_and_assignedPostsWithDates.get(counter_UsersWithPostsSize)
                                .put(userPostsWithDates.getString("body"), userPostsWithDates.getDate("date_of_post").toLocalDate());
                }
                counter_UserPostsQuantity++;
            }
            counter_UserPostsQuantity = 1;
            counter_UsersWithPostsSize++;
        }
        return mapWithUsersIds_and_assignedPostsWithDates;
    }

    public Map<String,LocalDate> getAllUserPostsWithDates(int userId) throws SQLException {
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
        int yearRange = LocalDate.now().getYear();

        String sql_INSERT = "INSERT INTO kodilla_course.posts VALUE (null, " + userId + ", " + postBody + ", MAKEDATE(" + yearRange + ", " + getRandomDayForPost() + "))";

        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sql_INSERT);
    }

    public int changeAllRoundedDatesOfPostsToRandom() throws SQLException {
        String sql_UPDATE = "UPDATE kodilla_course.posts SET date_of_post = CURRENT_DATE - INTERVAL FLOOR(RAND() * " + LocalDate.now().getDayOfYear() + ") DAY";

        Statement statement = dbManager.getConnection().createStatement();
        return statement.executeUpdate(sql_UPDATE);
    }
}
