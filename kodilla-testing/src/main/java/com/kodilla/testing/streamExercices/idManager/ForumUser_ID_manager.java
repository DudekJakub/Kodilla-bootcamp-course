package com.kodilla.testing.streamExercices.idManager;

import com.kodilla.testing.streamExercices.baseClasses.Forum;
import com.kodilla.testing.streamExercices.forumImpl.ForumUser;
import com.kodilla.testing.streamExercices.interfaces.ForumIDmanager;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class ForumUser_ID_manager implements ForumIDmanager {

    private static final Forum forum = new Forum();

    @Override
    public int nextID() {
        if (forum.getForumUsers().isEmpty()) {
            return 1;
        }
        return forum.getForumUsers().stream()
                .map(ForumUser::getId)
                .sorted(Comparator.naturalOrder())
                .reduce((first, second) -> second).get() + 1;
    }
}
