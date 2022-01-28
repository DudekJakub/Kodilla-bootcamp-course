package com.kodilla.patterns2.observer.forum;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
}
