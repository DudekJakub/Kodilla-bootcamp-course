package com.kodilla.testing.streamExercices.forumImpl;

import com.kodilla.testing.streamExercices.baseClasses.Post;
import com.kodilla.testing.streamExercices.idManager.ForumUser_ID_manager;
import com.kodilla.testing.streamExercices.baseClasses.Forum;
import com.kodilla.testing.streamExercices.interfaces.PostManager;
import com.kodilla.testing.streamExercices.validators.PostRemoveValidator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ForumUser implements PostManager {

    private final static ForumUser_ID_manager nextForumUserIDValue = new ForumUser_ID_manager();
    private final int id;
    private final String userName;
    private final char sex;
    private final LocalDate localDate;
    private int quantityOfPosts = 0;
    private final List<ForumPost> userPosts;

    public ForumUser(final String userName, final char sex, final LocalDate localDate) {
        Forum.addForumUserAtItCreation(this);
        this.id = nextForumUserIDValue.nextID();
        this.userName = userName;
        this.sex = sex;
        this.localDate = localDate;
        this.userPosts = new ArrayList<>();
    }

    @Override
    public void addPost(String postName, String postBody) {
        ForumPost userPost = new ForumPost(postName, postBody, this);
        Post.getForumPosts().put(userPost, this);
        userPosts.add(userPost);
        quantityOfPosts++;
    }

    @Override
    public void removePost(int postId) {
            var forumPost = Post.getForumPosts()
                    .keySet()
                    .stream()
                    .filter(id -> id.getPostId() == postId)
                    .findAny()
                    .orElse(null);

            assert forumPost != null;

            if (PostRemoveValidator.validatePostAssignedUser(forumPost, this)) {
                Post.getForumPosts().remove(forumPost);
                userPosts.remove(forumPost);
                quantityOfPosts--;
            } else {
                throw new RuntimeException("Post cannot be deleted. Validation for post's assigned user failed.");
            }
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public int getQuantityOfPosts() {
        return quantityOfPosts;
    }

    public List<ForumPost> getUserPosts() {
        return userPosts;
    }

    public void setQuantityOfPosts(int quantityOfPosts) {
        this.quantityOfPosts = quantityOfPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", localDate=" + localDate +
                ", quantityOfPosts=" + quantityOfPosts +
                '}';
    }

    public static class ForumUserBuilder {
        private String userName;
        private char sex;
        private LocalDate localDate;

        public ForumUserBuilder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public ForumUserBuilder sex(char sex) {
            this.sex = sex;
            return this;
        }

        public ForumUserBuilder localDate(LocalDate localDate) {
            this.localDate = localDate;
            return this;
        }

        public ForumUser build() {
            return new ForumUser(userName, sex, localDate);
        }
    }
}
