package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.SocialPublisher;

public class User {

    private final String userName;
    protected SocialPublisher socialPublisher;

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String sharePost() {
        return socialPublisher.share();
    }

    public String setSharingPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
        return socialPublisher.share();
    }
}
