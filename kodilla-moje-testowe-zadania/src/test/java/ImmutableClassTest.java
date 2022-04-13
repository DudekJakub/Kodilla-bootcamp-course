import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImmutableClassTest {

    @Test
    void testImmutable() {
        //Given
        ImmutableClass immutableClass = new ImmutableClass(3);
        immutableClass = new ImmutableClass(4);
        int x = immutableClass.getX();

        System.out.println(x);
        assertEquals(4, x);


    }
}