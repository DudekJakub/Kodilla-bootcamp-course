package com.kodilla.patterns.singleton.newSingleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewSingletonTest {

    @Test
    void testNewSingletonInit() {
        //Given
        //When
        NewSingleton newSingleton = NewSingleton.getInstance();

        newSingleton.name = "Kuba";
        String name = newSingleton.name;

        //Then
        assertEquals("Kuba", name);
    }

    @Test
    void testEnumSingletonInit() {
        //Given
        //When
        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE;
        EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE;

        enumSingleton1.setName("kuba");
        enumSingleton2.setName("Martyna");

        System.out.println("HashCode enumSingleton1 = " + enumSingleton1.hashCode());
        System.out.println("HashCode enumSingleton2 = " + enumSingleton2.hashCode());

        //Then
        assertFalse(enumSingleton1.getName().equalsIgnoreCase("KUBA"));

        assertTrue(enumSingleton1.getName().equalsIgnoreCase("MARTYNA"));

        assertEquals(enumSingleton1.hashCode(), enumSingleton2.hashCode());
    }

}