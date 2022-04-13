package com.kodilla.testing.streamExercices.baseClasses;

import com.kodilla.testing.streamExercices.forumImpl.ForumUser;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Forum {

    private static final List<ForumUser> forumUsers = new ArrayList<>();

    public static List<ForumUser> getForumUsers() {
        return forumUsers;
    }

    public static void addForumUserAtItCreation(ForumUser forumUser) {
        forumUsers.add(forumUser);
    }
}