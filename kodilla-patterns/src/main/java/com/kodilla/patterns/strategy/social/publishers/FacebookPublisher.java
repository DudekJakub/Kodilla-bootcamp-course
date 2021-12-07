package com.kodilla.patterns.strategy.social.publishers;

public class FacebookPublisher implements SocialPublisher {

    @Override
    public String share() {
        return "FACEBOOK";
    }
}
