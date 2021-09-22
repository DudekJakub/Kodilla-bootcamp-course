package com.kodilla.testing.forum.tdd;


import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;

@DisplayName("TDD: Forum Test Suite")
public class ForumTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Prepering to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for posts")
    class TestPosts {
        @Test
        void testAddPost() {
            //Given
            ForumUser forumUser = new ForumUser("MRSmith", "John Smith");

            //When
            forumUser.addPost("MRSmith", "Hello everyone, this is my first contribution here!");

            //Then
            Assertions.assertEquals(1, forumUser.getPostsQuantity());
        }

        @Test
        void testGetPost() {
            //Given
            ForumUser forumUser = new ForumUser("MRSmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "MRSmith");
            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

            //When
            ForumPost retrievedPost;
            retrievedPost = forumUser.getPost(0);

            //Then
            Assertions.assertEquals(thePost, retrievedPost);
        }

        @Test
        void testRemovePostNotExisting() {
            //Given
            ForumUser forumUser = new ForumUser("MRSmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "MRSmith");

            //When
            boolean result = forumUser.removePost(thePost);

            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void testRemovePost() {
            //Given
            ForumUser forumUser = new ForumUser("MRSmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "MRSmith");
            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

            //When
            boolean result = forumUser.removePost(thePost);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getPostsQuantity());
        }
    }

    @Nested
    @DisplayName("Tests for comments")
    class TestComments {
        @Test
        void testAddComment() {
            //Given
            ForumUser forumUser = new ForumUser("MRSmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "MRSmith" );

            //When
            forumUser.addComment(thePost, "MRSmith", "Thank you for all good words!");

            //Then
            Assertions.assertEquals(1, forumUser.getCommentsQuantity());
        }

        @Test
        void testGetComment() {
            //Given
            ForumUser forumUser = new ForumUser("MRSmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "MRSmith");
            ForumComment theComment = new ForumComment(thePost, "Thank you for all good words!", "MRSmith");
            forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());

            //When
            ForumComment retrievedComment = forumUser.getComment(0);

            //Then
            Assertions.assertEquals(theComment, retrievedComment);
        }

        @Test
        void testRemoveCommentNotExisting() {
            //Given
            ForumUser forumUser = new ForumUser("MRSmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "MRSmith");
            ForumComment theComment = new ForumComment(thePost, "Thank you for all good words!", "MRSmith");

            //When
            boolean result = forumUser.removeComment(theComment);

            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void testRemoveComment() {
            //Given
            ForumUser forumUser = new ForumUser("MRSmith", "John Smith");
            ForumPost  thePost = new ForumPost("Hello everyone, this is my first contribution here!", "MRSmith");
            ForumComment theComment = new ForumComment(thePost, "Thank you for all good words!", "MRSmith");
            forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());

            //When
            boolean result = forumUser.removeComment(theComment);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getCommentsQuantity());
        }
    }
}
