package SQLstoredProcAndFunc;

import com.kodilla.jdbc.DbManager;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class StoredProcTestSuite {

    @Test
    public void testUpdateVipLevels() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE kodilla_course.readers SET VIP_LEVEL='Not set'";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        //When
        String sqlProcedureCall = "CALL kodilla_course.UpdateVipLevels()";
        statement.execute(sqlProcedureCall);

        //Then
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM kodilla_course.readers WHERE VIP_LEVEL='Not set'";
        ResultSet rS = statement.executeQuery(sqlCheckTable);

        int howMany = -1;
        if (rS.next()) {
            howMany = rS.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
        rS.close();
        statement.close();
    }

    @Test
    public void testUpdateBestsellers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE kodilla_course.books SET BESTSELLER=false";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        //When
        String sqlProcedureCall = "CALL kodilla_course.UpdateBestsellers()";
        statement.execute(sqlProcedureCall);

        //Then
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY_BESTSELLERS FROM kodilla_course.books WHERE BESTSELLER = true";
        ResultSet rS = statement.executeQuery(sqlCheckTable);

        int howMany = 0;
        if (rS.next()) {
            howMany = rS.getInt("HOW_MANY_BESTSELLERS");
        }
        assertEquals(1, howMany);
        rS.close();
        statement.close();
    }
}
