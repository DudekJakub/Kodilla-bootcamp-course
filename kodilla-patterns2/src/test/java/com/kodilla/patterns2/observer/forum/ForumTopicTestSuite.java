package com.kodilla.patterns2.observer.forum;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ForumTopicTestSuite {

    @Test
    public void testUpdate() {
        //Given
        ForumTopic javaHelpForumTopic = new JavaHelpForumTopic();
        ForumTopic javaToolsForumTopic = new JavaToolsForumTopic();

        ForumUser jakubdudek = new ForumUser("Jakub Dudek");
        ForumUser bartoszsmerek = new ForumUser("Bartosz Smerek");

        javaHelpForumTopic.registerObserver(jakubdudek);
        javaToolsForumTopic.registerObserver(jakubdudek);
        javaToolsForumTopic.registerObserver(bartoszsmerek);

        //When
        javaHelpForumTopic.addPost("Siema. To mój pierwszy post tutaj");
        javaHelpForumTopic.addPost("Cześć. Też jestem tu nowy");
        javaToolsForumTopic.addPost("Forum Topic has been created. WELCOME!");

        //Then
        assertEquals(3, jakubdudek.getUpdateCount());
        assertEquals(1, bartoszsmerek.getUpdateCount());
    }

    @Test
    public void testForumUserAddPostToChosenTopic() {
        //Given
        ForumTopic javaHelpForumTopic = new JavaHelpForumTopic();
        ForumUser jakub_dudek = new ForumUser("Jakub Dudek");

        javaHelpForumTopic.addMemberToTopic(jakub_dudek);
        jakub_dudek.addPostToTopic(javaHelpForumTopic, "Hello!");
        javaHelpForumTopic.registerObserver(jakub_dudek);
        javaHelpForumTopic.addPost("Hello everyone. This is new Java-Help-Forum!");


        System.out.println("\nJavaHelpForumTopic members list: " + javaHelpForumTopic.members + "\nobservers list: " + javaHelpForumTopic.getObservers() + "\nposts list: " + javaHelpForumTopic.getMessages());

        assertEquals(1, jakub_dudek.getUpdateCount());
    }
}
