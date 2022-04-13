package com.kodilla.patterns2.observer.forum;

public class JavaHelpForumTopic extends ForumTopic {

    public JavaHelpForumTopic() {
        super("Java Help Group");
    }

    @Override
    protected void addMemberToTopic(ForumUser forumUser) {
        try {
            if (userValidator.checkIfUserAccIsOlderThen2Years(forumUser)) {
                members.add(forumUser);
            } else {
                throw new RuntimeException("Validation for " + forumUser.getUsername() + " has failed!");
            }
        } catch (RuntimeException e) {
            log.info("User account is not old enough to join this topic!");
        }
    }
}
