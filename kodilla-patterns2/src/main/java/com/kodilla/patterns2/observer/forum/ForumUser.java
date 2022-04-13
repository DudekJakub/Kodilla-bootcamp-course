package com.kodilla.patterns2.observer.forum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class ForumUser implements Observer {

    private final String username;
    private final LocalDate dateOfRegister;
    private int updateCount;
    private ForumUserValidator userValidator;
    private final static Logger log = LoggerFactory.getLogger(ForumUser.class);

    public ForumUser(String username) {
        this.username = username;
        this.dateOfRegister = LocalDate.now();
    }

    @Override
    public void update(ForumTopic forumTopic) {
        System.out.println(username + ": New messages in topic " + forumTopic.getName() + "\nTotal messages: " + forumTopic.getMessages().size());
        updateCount++;
    }

    public void addPostToTopic(ForumTopic forumTopic, String postContent) {
        try {
            if (userValidator.checkIfUserIsMemberOfTopic(forumTopic, this)) {
                forumTopic.addPost(postContent);
            } else {
                throw new RuntimeException("User " + this.getUsername() + " is NOT member of this topic!");
            }
        } catch (RuntimeException e) {
            log.info("You are not member of this topic. You cannot add any message (but You can still observe this topic)!");
        }
    }

    public String getUsername() {
        return username;
    }

    public int getUpdateCount() {
        return updateCount;
    }

    public LocalDate getDateOfRegister() {
        return dateOfRegister;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "username='" + username + '\'' +
                ", dateOfRegister=" + dateOfRegister +
                '}';
    }
}
