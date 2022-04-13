package ISP.exerciseHumanRobot.after_refactored;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessHallAndFactoryTestSuite {

    @Test
    void testMessHallManage() {
        //Given
        List<IEater> workers = List.of(new Human());
        MessHall messHall = new MessHall(workers);

        //When
        int quantityEatersResult = messHall.manage();

        //Then
        assertEquals(1, quantityEatersResult);
    }

    @Test
    void testFactoryManage() {
        //Given
        List<IWorker> workers = Arrays.asList(new Human(), new Robot());
        Factory factory = new Factory(workers);

        //When
        int quantityWorkersResult = factory.manage();

        //Then
        assertEquals(2, quantityWorkersResult);
    }

}