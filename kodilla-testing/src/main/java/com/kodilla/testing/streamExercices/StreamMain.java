package com.kodilla.testing.streamExercices;

import com.kodilla.testing.streamExercices.baseClasses.Forum;
import com.kodilla.testing.streamExercices.forumImpl.ForumUser;

import java.time.LocalDate;

public class StreamMain {

    public static void main(String[] args) {

        Forum forum = new Forum();
        ForumUser jakub = new ForumUser.ForumUserBuilder()
                .userName("Jakub")
                .sex('m')
                .localDate(LocalDate.of(1994,6,16))
                .build();

        ForumUser martyna = new ForumUser.ForumUserBuilder()
                .userName("Martyna")
                .sex('f')
                .localDate(LocalDate.of(1993,7,29))
                .build();

        forum
                .getForumUsers()
                .add(jakub);

        forum
                .getForumUsers()
                .add(martyna);

        System.out.println(jakub);
        System.out.println(martyna);

    }
}
