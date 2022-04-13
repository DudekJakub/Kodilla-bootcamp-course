package ISP.exerciseHumanRobot.before_refactored;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessHallAndFactoryTestSuite {

    @Test
    void testMessHallManage() {
        //Given
        List<Worker> workers = Arrays.asList(new Human(), new Robot());
        MessHall messHall = new MessHall(workers);

        //When
        try {
            messHall.manage();
        } catch (RuntimeException runtimeException) {
            runtimeException.printStackTrace();
        }

        //Then
        Throwable exception = assertThrows(RuntimeException.class, messHall::manage);
        assertEquals("Robot can't eat!", exception.getMessage());
    }

    @Test
    void testFactoryManage() {
        //Given
        List<Worker> workers = Arrays.asList(new Human(), new Robot());
        Factory factory = new Factory(workers);

        //When
        int quantityWorkersResult = factory.manage();

        //Then
        assertEquals(2, quantityWorkersResult);
    }

}