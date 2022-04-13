import com.kodilla.jdbc.DbManager;
import com.kodilla.jdbc.QueryExecutorSQL;
import com.kodilla.jdbc.practice.PostConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {PostConfiguration.class})
public class DbManagerTestSuite {

    private static DbManager dbManager;

    @BeforeAll
    static void setDbConnection() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PostConfiguration.class);
        dbManager = applicationContext.getBean(DbManager.class);
    }

    @Test
    void testConnect() {
        //Given && When
        Connection connection = dbManager.getConnection();
        //Then
        Assertions.assertNotNull(connection);
    }

    @Test
    void testSelectUser() throws SQLException {
        //Given
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PostConfiguration.class);
        DbManager dbManager = applicationContext.getBean(DbManager.class);
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
        Assertions.assertEquals(6, counter);
    }

    @Test
    void testSelectUsersAndPosts() throws SQLException {
        //Given

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
        Assertions.assertEquals(5, counter);
    }

    @Test
    void testSelectUsersAndTheirPostsBody() throws SQLException {
        //Given
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

        Assertions.assertEquals(12, counter);
        Assertions.assertEquals(12, usersAndTheirPosts.size());
    }

    @Test
    void testHowManyUsersHaveNoPosts() throws SQLException {
        //Given

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

        Assertions.assertEquals(1, numberOfUsersWithoutPosts);
        Assertions.assertEquals(1, usersWithoutPosts.size());
    }

    @Test
    void testAddColumnToEntity() throws SQLException {
        //Given
        String tableName = "posts";
        String columnName = "date_of_post";
        String columnParameters = "DATE NOT NULL";

        //When
        /** I know it isn't good practice making that kind of test, but I am still just learning stuff ;) */
        String checkIfTableAlreadyExists_query = "SHOW COLUMNS FROM kodilla_course.posts WHERE Field = 'date_of_post'";
        Statement statement1 = dbManager.getConnection().createStatement();
        statement1.executeQuery(checkIfTableAlreadyExists_query);
        ResultSet checkIfColumnAlreadyExists = statement1.getResultSet();
        if (!checkIfColumnAlreadyExists.next()) {
            QueryExecutorSQL.addNewColumnToTable(tableName, columnName, columnParameters);
        }
        checkIfColumnAlreadyExists.close();
        statement1.close();

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
