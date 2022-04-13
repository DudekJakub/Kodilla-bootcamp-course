package com.kodilla.testing.streamExercices.forumImpl;

import com.kodilla.testing.streamExercices.idManager.ForumPost_ID_manager;

public class ForumPost {

    private final static ForumPost_ID_manager idForPost = new ForumPost_ID_manager();
    private final String postName;
    private final String postBody;
    private final int postId;
    private ForumUser forumUser;

    public ForumPost(final String postName, final String postBody, ForumUser forumUser) {
        this.postName = postName;
        this.postBody = postBody;
        this.forumUser = forumUser;
        this.postId = idForPost.nextID();
    }

    public void setForumUser(ForumUser forumUser) {
        this.forumUser = forumUser;
    }

    public ForumUser getForumUser() {
        return forumUser;
    }

    public String getPostName() {
        return postName;
    }

    public String getPostBody() {
        return postBody;
    }

    public int getPostId() {
        return postId;
    }

    @Override
    public String toString() {
        return "ForumPost{" +
                "postName='" + postName + '\'' +
                ", postBody='" + postBody + '\'' +
                ", postId=" + postId +
                ", forumUser=" + forumUser +
                '}';
    }
}
