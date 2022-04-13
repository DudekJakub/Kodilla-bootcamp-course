package LSP.myExample.brokenLSP.Animals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EagleTest {

    @Test
    void swim() {
        //Given
        Animal animal = new Eagle(10, 10);

        //When
        Throwable exception = assertThrows(Exception.class, animal::swim);

        //Then
        assertEquals("Eagle cannot swim!", exception.getMessage());
    }
}