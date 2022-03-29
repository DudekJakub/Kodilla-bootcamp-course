import com.kodilla.jdbc.DbManager;
import com.kodilla.jdbc.QueryExecutorSQL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class DbManagerTestSuite {

    @Test
    void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        Assertions.assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUser() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("ID") + ", " + resultSet.getString("FIRSTNAME") +
                               ", " + resultSet.getString("LASTNAME"));
                               counter++;
        }
        resultSet.close();
        statement.close();
        Assertions.assertEquals(5, counter);
    }

    @Test
    void testSelectUsersAndPosts() throws SQLException {
        //Given
        DbManager dbManager= DbManager.getInstance();

        //When
        String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POSTS_NUMBER\n" +
                "FROM USERS U JOIN POSTS P on U.ID = P.USER_ID\n" +
                "GROUP BY P.USER_ID\n" +
                "HAVING COUNT(*) >= 2";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rS = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        System.out.println("USER | POSTS NUMBER");
        while (rS.next()) {
            System.out.println(rS.getString("FIRSTNAME") + " " + rS.getString("LASTNAME") + ": " + rS.getInt("POSTS_NUMBER"));
            counter++;
        }
        rS.close();
        statement.close();
        Assertions.assertEquals(2, counter);
    }

    @Test
    void testSelectUsersAndTheirPostsBody() throws SQLException {
        //Given
        DbManager dbManager = DbManager.INSTANCE;
        List<String> usersAndTheirPosts = new ArrayList<>();

        //When
        String sqlQuery = "SELECT U.LASTNAME, U.ID, P.BODY FROM users U JOIN posts P ON U.ID = P.USER_ID";

        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        System.out.println("USER | POST BODY");

        while (rs.next()) {
            System.out.println(rs.getString("LASTNAME") + " | " + rs.getString("BODY"));
            usersAndTheirPosts.add("userID = " + rs.getString("ID") + "| " + rs.getString("LASTNAME") + " | " + rs.getString("BODY"));
            counter++;
        }
        rs.close();
        statement.close();

        System.out.println("\n\nLIST OF USERS AND THEIR POSTS");

        usersAndTheirPosts.sort(Comparator.naturalOrder());

        for (String post : usersAndTheirPosts) {
            System.out.println(post);
        }

        Assertions.assertEquals(6, counter);
        Assertions.assertEquals(6, usersAndTheirPosts.size());
    }

    @Test
    void testHowManyUsersHaveNoPosts() throws SQLException {
        //Given
        DbManager dbManager = DbManager.INSTANCE;

        Collection<String> usersWithoutPosts = new HashSet<>();

        //When
        String sqlQuery = "SELECT U.LASTNAME, P.BODY, P.USER_ID FROM users U LEFT JOIN posts P ON U.ID = P.USER_ID WHERE BODY is null";

        Statement statement = dbManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        //Then
        int numberOfUsersWithoutPosts = 0;

        while (resultSet.next()) {
            usersWithoutPosts.add(resultSet.getString("LASTNAME"));
            numberOfUsersWithoutPosts++;
        }
        resultSet.close();
        statement.close();

        System.out.println("\nUSERS WITHOUT POSTS\n" + usersWithoutPosts + " = " + usersWithoutPosts.size() + " user(s).");

        Assertions.assertEquals(3, numberOfUsersWithoutPosts);
        Assertions.assertEquals(2, usersWithoutPosts.size());
    }

    @Test
    void testAddColumnToEntity() throws SQLException {
        //Given
        DbManager dbManager = DbManager.INSTANCE;

        String tableName = "posts";
        String columnName = "date_of_post";
        String columnParameters = "DATE NOT NULL";

        //When
        QueryExecutorSQL.addNewColumnToTable(tableName, columnName, columnParameters);

        //Then
        Statement statement = dbManager.getConnection().createStatement();


        String checkSQL = "SELECT date_of_post FROM " + tableName;

        boolean isNewColumnExist;
        try {
            ResultSet resultSet = statement.executeQuery(checkSQL);

            isNewColumnExist = resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        statement.close();

        assertTrue(isNewColumnExist);
    }
}
