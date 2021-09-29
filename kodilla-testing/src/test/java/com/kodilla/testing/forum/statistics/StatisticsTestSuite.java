package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Statistics Test Suite:")
public class StatisticsTestSuite {

    private ForumStatisticsCalculator forumStatisticsCalculator;
    private Statistics statisticsMock;

    @BeforeEach
    void beforeTest() {
        statisticsMock = mock(Statistics.class);

        List<String> listMock = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            listMock.add("User");
        }

        when(statisticsMock.usersNames()).thenReturn(listMock);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        forumStatisticsCalculator = new ForumStatisticsCalculator();

        System.out.println("Statistics Test Case: begin");
    }

    @AfterEach
    void afterTest() {
        System.out.println("Statistics Test Case: end\n");
    }

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("Statistics Test Suite: begin\n");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("Statistics Test Suite: end");
    }

    @Test
    void test0Posts() {
        //Given
        List<String> listMock = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            listMock.add("User");
        }

        //When
        when(statisticsMock.usersNames()).thenReturn(listMock);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(5);
        forumStatisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(0, forumStatisticsCalculator.getAverageQuantityOfCommentsPerPost());
        assertEquals(1.0, forumStatisticsCalculator.getAverageQuantityOfCommentsPerUser());
        assertEquals(0, forumStatisticsCalculator.getAverageQuantityOfPostsPerUser());
    }

    @Test
    void test1000Posts() {
        //Given
        List<String> listMock = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            listMock.add("User");
        }

        //When
        when(statisticsMock.usersNames()).thenReturn(listMock);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(10);
        forumStatisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(200, forumStatisticsCalculator.getAverageQuantityOfPostsPerUser());
        assertEquals(2, forumStatisticsCalculator.getAverageQuantityOfCommentsPerUser());
        assertEquals(0.01, forumStatisticsCalculator.getAverageQuantityOfCommentsPerPost());
    }

    @Test
    void test0Comments() {
        //Given
        List<String> listMock = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            listMock.add("User");
        }

        //When
        when(statisticsMock.usersNames()).thenReturn(listMock);
        when(statisticsMock.postsCount()).thenReturn(18);
        when(statisticsMock.commentsCount()).thenReturn(0);
        forumStatisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(3.6, forumStatisticsCalculator.getAverageQuantityOfPostsPerUser());
        assertEquals(0, forumStatisticsCalculator.getAverageQuantityOfCommentsPerUser());
        assertEquals(0, forumStatisticsCalculator.getAverageQuantityOfCommentsPerPost());
    }

    @Test
    void testLessCommentsThenPosts() {
        //Given
        List<String> listMock = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            listMock.add("User");
        }

        //When
        when(statisticsMock.usersNames()).thenReturn(listMock);
        when(statisticsMock.postsCount()).thenReturn(20);
        when(statisticsMock.commentsCount()).thenReturn(10);
        forumStatisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(4 , forumStatisticsCalculator.getAverageQuantityOfPostsPerUser());
        assertEquals(2, forumStatisticsCalculator.getAverageQuantityOfCommentsPerUser());
        assertEquals(0.5, forumStatisticsCalculator.getAverageQuantityOfCommentsPerPost());
    }

    @Test
    void testLessPoststhenComments() {
        //Given
        List<String> listMock = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            listMock.add("User");
        }

        //When
        when(statisticsMock.usersNames()).thenReturn(listMock);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(21);
        forumStatisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(2, forumStatisticsCalculator.getAverageQuantityOfPostsPerUser());
        assertEquals(4.2, forumStatisticsCalculator.getAverageQuantityOfCommentsPerUser());
        assertEquals(2.1 , forumStatisticsCalculator.getAverageQuantityOfCommentsPerPost());
    }

    @Test
    void testUserCount0() {
        //Given
        List<String> listMock = new ArrayList<>();

        //When
        when(statisticsMock.usersNames()).thenReturn(listMock);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        forumStatisticsCalculator.calculateAdvStatistics(statisticsMock);

        //
        assertEquals(0, forumStatisticsCalculator.getUsersQuantity());
        assertEquals(0, forumStatisticsCalculator.getAverageQuantityOfPostsPerUser());
        assertEquals(0, forumStatisticsCalculator.getAverageQuantityOfCommentsPerUser());
        assertEquals(0, forumStatisticsCalculator.getAverageQuantityOfCommentsPerPost());
    }

    @Test
    void testUserCount100() {
        //Given
        List<String> listMock = new ArrayList<>();
        for (int i=0; i<100; i++) {
            listMock.add("User");
        }

        //When
        when(statisticsMock.usersNames()).thenReturn(listMock);
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(100);
        forumStatisticsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(0.5, forumStatisticsCalculator.getAverageQuantityOfPostsPerUser());
        assertEquals(1, forumStatisticsCalculator.getAverageQuantityOfCommentsPerUser());
        assertEquals(2, forumStatisticsCalculator.getAverageQuantityOfCommentsPerPost());
    }
}
