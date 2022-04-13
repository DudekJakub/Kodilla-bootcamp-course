package com.kodilla.testing.streamExercices;

import com.kodilla.testing.streamExercices.baseClasses.Forum;
import com.kodilla.testing.streamExercices.baseClasses.Post;
import com.kodilla.testing.streamExercices.forumImpl.ForumPost;
import com.kodilla.testing.streamExercices.forumImpl.ForumUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ForumUserTestSuite {

    private ForumUser jakub;
    private ForumUser martyna;

    @BeforeEach
    void setStartSettings(){
        jakub = new ForumUser.ForumUserBuilder()
                .userName("Jakub")
                .sex('m')
                .localDate(LocalDate.of(1994,6,17))
                .build();

        martyna = new ForumUser.ForumUserBuilder()
                .userName("Martyna")
                .sex('f')
                .localDate(LocalDate.of(1993,7,28))
                .build();
    }

    @AfterEach
    void cleanMemory() {
        Forum.getForumUsers().clear();
        Post.getForumPosts().clear();
    }

    @Test
    public void testCreateNewForumUserAndIdValidation() {
        //Given & When
        ForumUser bartek = new ForumUser.ForumUserBuilder()
                .userName("Bartek")
                .sex('m')
                .localDate(LocalDate.of(1994,1,10))
                .build();

        //Then
        Forum.getForumUsers().forEach(fU -> {
            assertTrue(fU.getId() > 0);
            assertFalse(fU.getUserName().isEmpty());
            assertTrue(fU.getLocalDate().getYear() < LocalDate.now().getYear());
            assertEquals(0, fU.getQuantityOfPosts());
        });
        assertEquals(2, martyna.getId());
        assertEquals(3, bartek.getId());
    }

    @Test
    public void testIfAddPostMethodIsTriggered() {
        //Given
            //setStartSettings

        //When
        ForumUser jakub = mock(ForumUser.class);
        jakub.addPost("First_Post", "This is my first test post!");

        //Then
        Mockito.verify(jakub, Mockito.atLeastOnce()).addPost("First_Post", "This is my first test post!");
    }

    @Test
    public void testAddPostFunction() {
        //Given
            //setStartSettings

        //When
        jakub.addPost("First_Post", "This is my first test post!");

        //Then
        Post.getForumPosts()
                .keySet()
                .stream()
                .filter(fP -> fP.getForumUser().equals(jakub))
                .forEach(fP ->
                    {
                        assertEquals(fP.getForumUser(), jakub);
                        assertEquals(fP.getPostId(), 1);
                        assertTrue(fP.getPostBody().equalsIgnoreCase("This is my first test post!"));
                        assertTrue(fP.getPostName().equalsIgnoreCase("first_post"));
                    });

        //CleanUp
        jakub.setQuantityOfPosts(0);
    }

    @Test
    void testRemovePostFunction() {
        //Given
            //setStartSettings

        //When
        jakub.addPost("First_Post", "This is my first test post!");

        boolean isPostNameEquals =
                Objects.requireNonNull(Post.getForumPosts()
                        .values()
                        .stream()
                        .filter(fU -> fU.getId() == jakub.getId())
                        .findFirst()
                        .orElse(null))
                        .getUserPosts()
                        .get(0)
                        .getPostName()
                        .equalsIgnoreCase("first_post");

        assertTrue(isPostNameEquals);

        jakub.removePost(jakub.getUserPosts().get(0).getPostId());

        //Then
        assertEquals(0, Post.getForumPosts().size());
    }

    @Test
    public void testRemovePostValidator() {
        //Given
            //setStartSettings

        //When
        jakub.addPost("First_Post", "This is my first test post!");
        martyna.addPost("First_Post", "Hello Java World! :)");

        RuntimeException removePostException = assertThrows(RuntimeException.class,
                ()-> jakub.removePost(martyna.getUserPosts().get(0).getPostId()),
                "Post cannot be deleted. Validation for post's assigned user failed.");

        //Then
        assertTrue(removePostException.getMessage().contains("failed"));
    }

    @Test
    public void testAdvanceStreamOperationOnForumUserList() {
        //Given
        ForumUser kacper = new ForumUser.ForumUserBuilder()
                .userName("Kacper")
                .sex('M')
                .localDate(LocalDate.of(2010,10,11))
                .build();

        ForumUser bartek = new ForumUser.ForumUserBuilder()
                .userName("Bartek")
                .sex('m')
                .localDate(LocalDate.of(1994,1,10))
                .build();

        kacper.addPost("Heyo!", "I am a little madafaka boy!");
        jakub.addPost("JavaTime", "I love learning Java Language ;)");
        jakub.removePost(jakub.getUserPosts().get(0).getPostId());

        List<ForumUser> forumUsers = Forum.getForumUsers();
        forumUsers.addAll(List.of(kacper,bartek));

        //When
        var userListAfterStream = forumUsers.stream()
                .filter(fU -> fU.getSex() == 'm' || fU.getSex() == 'M')
                .filter(fU -> LocalDate.now().getYear() - fU.getLocalDate().getYear() >= 20)
                .filter(fU -> fU.getQuantityOfPosts() >= 1)
                .collect(Collectors.toMap(ForumUser::getId, ForumUser::getUserName));

        //Then
        assertEquals(0, userListAfterStream.size());
    }

    @Test
    public void testStreamToSumAllUserPostsQuantity() {
        //Given
        martyna.addPost("Heyo!", "I am a little madafaka boy!");
        jakub.addPost("JavaTime", "I love learning Java Language ;)");

        //When
        var sumOfAllUserPostsQuantity = Post.getForumPosts()
                .keySet()
                .stream()
                .map(ForumPost::getForumUser)
                .map(ForumUser::getQuantityOfPosts)
                .reduce((f,s) -> f+s);


        //funny way
        var otherWayToSumAboveValue = Post.getForumPosts()
                .entrySet()
                        .stream()
                                .map(ForumPost -> ForumPost.getKey().getForumUser())
                                        .map(ForumUser::getQuantityOfPosts)
                                                .reduce(Integer::sum);

        var flatMapWayToSumAboveValue = Post.getForumPosts()
                .keySet()
                .stream()
                .flatMap(forumPost -> forumPost.getForumUser().getUserPosts().stream())
                .map(posts -> posts.getForumUser().getQuantityOfPosts())
                .reduce((firstValue, secondValue) -> firstValue + secondValue);

        //Then
        assertEquals(2, sumOfAllUserPostsQuantity.orElse(0));
        assertEquals(2, otherWayToSumAboveValue.orElse(0));
        assertEquals(2, flatMapWayToSumAboveValue.orElse(0));
    }

    @Test
    public void measureModeOfUsersPostQuantityWithStream() {
        //Given
        ForumUser kacper = new ForumUser.ForumUserBuilder()
                .userName("Kacper")
                .sex('M')
                .localDate(LocalDate.of(2010,10,11))
                .build();

        ForumUser bartek = new ForumUser.ForumUserBuilder()
                .userName("Bartek")
                .sex('m')
                .localDate(LocalDate.of(1994,1,10))
                .build();

        kacper.addPost("Heyo!", "I am a little madafaka boy!");
        bartek.addPost("Heyo!", "I am a little madafaka boy!");
        martyna.addPost("Heyo!", "I am a little madafaka boy!");
        martyna.addPost("Heyo!", "I am a little madafaka boy!");
        martyna.addPost("Heyo!", "I am a little madafaka boy!");
        jakub.addPost("JavaTime", "I love learning Java Language ;)");
        jakub.addPost("JavaTime", "I love learning Java Language ;)");
        jakub.addPost("JavaTime", "I love learning Java Language ;)");

        //When
        var naturalSortedListOfUsersQuantityValues = Forum.getForumUsers().stream()
                .map(ForumUser::getQuantityOfPosts)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        var mode = naturalSortedListOfUsersQuantityValues.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet()
                .stream()
                .reduce((f, s) -> f.getValue() > s.getValue() ? f : s);

        System.out.println(mode);

        //Then
        assertEquals(1, kacper.getUserPosts().size());
        assertEquals(1, bartek.getUserPosts().size());
        assertEquals(3, martyna.getUserPosts().size());
        assertEquals(3, jakub.getUserPosts().size());
        assertEquals(4, naturalSortedListOfUsersQuantityValues.size());
        mode.ifPresent(i -> assertEquals(3, i.getKey()));
    }

    @Test
    public void measureMedianOfUsersPostQuantityWithStream() {
        //Given
        ForumUser kacper = new ForumUser.ForumUserBuilder()
                .userName("Kacper")
                .sex('M')
                .localDate(LocalDate.of(2010,10,11))
                .build();

        ForumUser bartek = new ForumUser.ForumUserBuilder()
                .userName("Bartek")
                .sex('m')
                .localDate(LocalDate.of(1994,1,10))
                .build();

        kacper.addPost("Heyo!", "I am a little madafaka boy!");
        bartek.addPost("Heyo!", "I am a little madafaka boy!");
        bartek.addPost("Heyo!", "I am a little madafaka boy!");
        martyna.addPost("Heyo!", "I am a little madafaka boy!");
        martyna.addPost("Heyo!", "I am a little madafaka boy!");
        martyna.addPost("Heyo!", "I am a little madafaka boy!");
        martyna.addPost("Heyo!", "I am a little madafaka boy!");
        jakub.addPost("JavaTime", "I love learning Java Language ;)");
        jakub.addPost("JavaTime", "I love learning Java Language ;)");
        jakub.addPost("JavaTime", "I love learning Java Language ;)");

        //When
        var sortedQuantityValues = Forum.getForumUsers().stream()
                .map(ForumUser::getQuantityOfPosts)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        var median = (int) Forum.getForumUsers().stream().map(ForumUser::getQuantityOfPosts).count() % 2 == 0 ?

                        Forum.getForumUsers().stream()
                                .map(ForumUser::getQuantityOfPosts).sorted()
                                .mapToDouble(Integer::doubleValue)
                                .skip(sortedQuantityValues.size()/2-1).limit(2).reduce((f,s) -> (f+s)/2)
                                .orElse(0)
                :
                        Forum.getForumUsers().stream()
                                .map(ForumUser::getQuantityOfPosts).sorted()
                                .skip(sortedQuantityValues.size()/2).findFirst().orElse(0);

        System.out.println(sortedQuantityValues);
        System.out.println(median);

        assertEquals(2.5, median);
    }
}