package LSP.myExample.brokenLSP.Animals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BirdTest {

    @Test
    void testIfAbstractInherentWorksProperly() {
        //Given
        Bird bird = new Eagle(5,10);

        //When
        int sizeResult = bird.getSize();

        //Then
        assertEquals(50, sizeResult);
    }

}