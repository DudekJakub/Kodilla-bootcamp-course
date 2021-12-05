package com.kodilla.kodillaspring;

import com.kodilla.spring.shape.Circle;
import com.kodilla.spring.shape.Shape;
import com.kodilla.spring.shape.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class KodillaSpringApplicationTests {

    @Test
    void testCircleLoadedIntoContainer() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = context.getBean(Circle.class);

        //When
        String name = shape.getShapeName();

        //Then
        Assertions.assertEquals("This is a circle", name);
    }

    @Test
    void testTriangleLoadedIntoContainer() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = context.getBean(Triangle.class);

        //When
        String name = shape.getShapeName();

        //Then
        Assertions.assertEquals("This is a triangle", name);
    }

    @Test
    void contextLoads() {
    }
}
