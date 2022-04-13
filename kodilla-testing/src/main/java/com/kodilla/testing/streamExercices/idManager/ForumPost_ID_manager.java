package com.kodilla.testing.streamExercices.idManager;

import com.kodilla.testing.streamExercices.baseClasses.Post;
import com.kodilla.testing.streamExercices.forumImpl.ForumPost;
import com.kodilla.testing.streamExercices.interfaces.ForumIDmanager;

public class ForumPost_ID_manager implements ForumIDmanager {

    private static final Post post = new Post();

    @Override
    public int nextID() {
        if (Post.getForumPosts().isEmpty()) {
            return 1;
        }
        return Post.getForumPosts()
                .keySet()
                .stream()
                .map(ForumPost::getPostId)
                .reduce((first, second) -> second)
                .get() + 1;
    }
}
