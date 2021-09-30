package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> theUserList = new ArrayList<>();

    public Forum() {
        theUserList.add(new ForumUser(640, "Jackoby", 'M', 1994, 6, 17, 130));
        theUserList.add(new ForumUser(304, "Martinix", 'F', 1993, 7, 20, 98));
        theUserList.add(new ForumUser(234, "Jhooony", 'M', 1990, 1, 20, 9));
        theUserList.add(new ForumUser(122, "KaroLux", 'M', 1983, 3, 5, 50));
        theUserList.add(new ForumUser(109, "WisdomMate", 'M', 2000, 12, 2, 32));
        theUserList.add(new ForumUser(178, "LolingIsCool", 'F', 2003, 11, 22, 45));
    }

    public ArrayList<ForumUser> getUserList() {
        return new ArrayList<>(theUserList);
    }
}
