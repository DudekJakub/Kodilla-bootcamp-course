package com.kodilla.patterns.strategy.social.publishers;

public class SnapchatPublisher implements SocialPublisher {

    @Override
    public String share() {
        return "SNAPCHAT";
    }
}
