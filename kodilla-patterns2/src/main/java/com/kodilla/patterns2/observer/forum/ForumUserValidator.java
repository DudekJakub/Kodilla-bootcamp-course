package com.kodilla.patterns2.observer.forum;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

public class ForumUserValidator implements UserValidator{

    @Override
    public boolean checkIfUserAccIsOlderThen2Years(ForumUser forumUser) {
        return forumUser.getDateOfRegister().isBefore(LocalDate.of(2022, 1, 1));
    }

    @Override
    public boolean checkIfUserAccIsOlderThen1Year(ForumUser forumUser) {
        return forumUser.getDateOfRegister().isBefore(LocalDate.of(2021,1,1));
    }

    @Override
    public boolean checkIfUserIsMemberOfTopic(ForumTopic forumTopic, ForumUser forumUser) {
        return forumTopic.members.contains(forumUser);
    }
}
