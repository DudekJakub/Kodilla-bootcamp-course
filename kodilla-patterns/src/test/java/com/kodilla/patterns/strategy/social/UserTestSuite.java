package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.SnapchatPublisher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User jakub = new ZGeneration("Jackob");
        User martyna = new Millenials("Martinix");
        User grzegorz = new YGeneration("Greg");

        //When
        String jakubShareChoice = jakub.sharePost();
        System.out.println("Jackob shares posts via " + jakubShareChoice);
        String martynaShareChoice = martyna.sharePost();
        System.out.println("Martinix shares posts via " + martynaShareChoice);
        String grzegorzShareChoice = grzegorz.sharePost();
        System.out.println("Greg shares posts via " + grzegorzShareChoice);

        //Then
        Assertions.assertEquals("FACEBOOK", jakubShareChoice);
        Assertions.assertEquals("SNAPCHAT", martynaShareChoice);
        Assertions.assertEquals("TWITTER", grzegorzShareChoice);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User jakub = new ZGeneration("Jackob");

        //When
        String jakubShareChoise = jakub.sharePost();
        System.out.println("Jackob shares posts via " + jakubShareChoise);
        jakub.setSharingPublisher(new SnapchatPublisher());
        jakubShareChoise = jakub.sharePost();
        System.out.println("Jackob NOW shares posts via " + jakubShareChoise);

        //Then
        Assertions.assertEquals("SNAPCHAT", jakubShareChoise);
    }
}
