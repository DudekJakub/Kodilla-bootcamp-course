package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.*;

@DisplayName("Forum Test Suite")
public class ForumTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Forum Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Forum Test Case: end \n");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Forum Test Suite: begin \n");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Forum Test Suite: end \n-------------");
    }


    @DisplayName("when create SimpleUser with realName, " +
                 "then getRealName should return real user name"
    )
    @Test
    void testCaseRealName() {
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser", "John Smith");
        //When
        String result = simpleUser.getRealName();
        System.out.println("Testing " + result);
        //Then
        Assertions.assertEquals("John Smith", result);
    }

    @DisplayName(
            "When created SimpleUser with name, " +
                    "then getUsername should return correct name"
    )
    @Test
    void testCaseUsername() {
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        //When
        String result = simpleUser.getUsername();
        String expectedResult = "theForumUser";
        System.out.println("Testing " + expectedResult);
        //Then
        Assertions.assertEquals(expectedResult, result);

    }
}
