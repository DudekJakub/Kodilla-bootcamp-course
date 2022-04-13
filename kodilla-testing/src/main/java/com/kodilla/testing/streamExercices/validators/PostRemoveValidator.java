package com.kodilla.testing.streamExercices.validators;

import com.kodilla.testing.streamExercices.forumImpl.ForumPost;
import com.kodilla.testing.streamExercices.forumImpl.ForumUser;

public class PostRemoveValidator {

    public static boolean validatePostAssignedUser(ForumPost forumPost, ForumUser forumUser) {
        return forumPost.getForumUser().equals(forumUser);
    }
}
