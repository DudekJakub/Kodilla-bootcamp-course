package com.kodilla.testing.streamExercices.baseClasses;

import com.kodilla.testing.streamExercices.forumImpl.ForumPost;
import com.kodilla.testing.streamExercices.forumImpl.ForumUser;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class Post {

    private final static Map<ForumPost, ForumUser> forumPosts = new HashMap<>();

    public static Map<ForumPost, ForumUser> getForumPosts() {
        return forumPosts;
    }
}
