package com.kodilla.patterns2.observer.forum;

import org.springframework.stereotype.Component;

public interface UserValidator {

    boolean checkIfUserAccIsOlderThen2Years(ForumUser forumUser);
    boolean checkIfUserAccIsOlderThen1Year(ForumUser forumUser);
    boolean checkIfUserIsMemberOfTopic(ForumTopic forumTopic, ForumUser forumUser);
}
