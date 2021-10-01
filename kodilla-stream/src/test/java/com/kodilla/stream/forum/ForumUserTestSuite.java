package com.kodilla.stream.forum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ForumUserTestSuite {

    @Test
    void testGetLocationOfFriends() {
        //Given
        ForumUser forumUser1 = new ForumUser("Mamuth", "Jakub", "Poznań");
        ForumUser forumUser2 = new ForumUser("Dżesika", "Justyna", "Warszawa");
        ForumUser forumUser3 = new ForumUser("Lux", "Lucyna", "Kraków");
        ForumUser forumUser4 = new ForumUser("Aram", "Arek", "Płock");
        ForumUser forumUser5 = new ForumUser("Graby", "Grzegorz", "Kołobrzeg");

        //When
        forumUser1.addFriend(forumUser2);
        forumUser1.addFriend(forumUser3);
        forumUser1.addFriend(forumUser4);

        forumUser2.addFriend(forumUser1);
        forumUser2.addFriend(forumUser3);
        forumUser2.addFriend(forumUser4);

        forumUser3.addFriend(forumUser2);
        forumUser3.addFriend(forumUser5);

        forumUser4.addFriend(forumUser5);

        forumUser5.addFriend(forumUser1);
        forumUser5.addFriend(forumUser4);

        //Then
        Assertions.assertEquals(3, forumUser1.getLocationOfFriends().size());
        Assertions.assertTrue(forumUser1.getLocationOfFriends().contains("Warszawa"));
        Assertions.assertTrue(forumUser1.getLocationOfFriends().contains("Kraków"));
        Assertions.assertTrue(forumUser1.getLocationOfFriends().contains("Płock"));
    }

    @Test
    void getLocationOfFriendsOfFriends() {
        //Given
        ForumUser forumUser1 = new ForumUser("Mamuth", "Jakub", "Poznań");
        ForumUser forumUser2 = new ForumUser("Dżesika", "Justyna", "Warszawa");
        ForumUser forumUser3 = new ForumUser("Lux", "Lucyna", "Kraków");
        ForumUser forumUser4 = new ForumUser("Aram", "Arek", "Płock");
        ForumUser forumUser5 = new ForumUser("Graby", "Grzegorz", "Kołobrzeg");

        //When
        forumUser1.addFriend(forumUser2);
        forumUser1.addFriend(forumUser3);
        forumUser1.addFriend(forumUser4);

        forumUser2.addFriend(forumUser1);
        forumUser2.addFriend(forumUser3);
        forumUser2.addFriend(forumUser4);

        forumUser3.addFriend(forumUser2);
        forumUser3.addFriend(forumUser5);

        forumUser4.addFriend(forumUser5);

        forumUser5.addFriend(forumUser1);
        forumUser5.addFriend(forumUser4);

        //Then
        Assertions.assertEquals(4, forumUser1.getLocationOfFriendsOfFriends().size());
        Assertions.assertTrue(forumUser1.getLocationOfFriendsOfFriends().contains("Kraków"));
        Assertions.assertTrue(forumUser1.getLocationOfFriendsOfFriends().contains("Płock"));
        Assertions.assertTrue(forumUser1.getLocationOfFriendsOfFriends().contains("Warszawa"));
        Assertions.assertTrue(forumUser1.getLocationOfFriendsOfFriends().contains("Kołobrzeg"));
        Assertions.assertFalse(forumUser1.getLocationOfFriendsOfFriends().contains("Poznań"));

    }
}
