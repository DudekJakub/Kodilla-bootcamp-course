package com.kodilla.testing.streamExercices.interfaces;

import com.kodilla.testing.forum.ForumUser;

public interface PostManager {

    void addPost(String postName, String postBody);
    void removePost(int postId);
}
