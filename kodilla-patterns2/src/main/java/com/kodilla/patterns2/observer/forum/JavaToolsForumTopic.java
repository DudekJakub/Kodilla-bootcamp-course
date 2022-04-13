package com.kodilla.patterns2.observer.forum;

public class JavaToolsForumTopic extends ForumTopic {

    public JavaToolsForumTopic() {
        super("Java Tools Group");
    }

    @Override
    protected void addMemberToTopic(ForumUser forumUser) {
        try {
            if (userValidator.checkIfUserAccIsOlderThen1Year(forumUser)) {
                members.add(forumUser);
            } else {
                throw new RuntimeException("Validation for " + forumUser.getUsername() + " has failed!");
            }
        } catch (RuntimeException e) {
            log.info("User account is not old enough to join this topic!");
        }
    }
}
