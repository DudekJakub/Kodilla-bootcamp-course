import com.kodilla.jdbc.DbManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
