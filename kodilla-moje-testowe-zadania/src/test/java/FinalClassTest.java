import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinalClassTest {

    @Test
    void testFinalClass() {
        //Given
        FinalClass finalClass = new FinalClass(2);
        finalClass.setX(3);

        final int x = finalClass.getX();

        assertEquals(3, finalClass.x);

        FinalClass secondFinalClass = finalClass; //

        finalClass = secondFinalClass;
        finalClass = new FinalClass(4);

//        x = secondFinalClass.getX();
    }
}