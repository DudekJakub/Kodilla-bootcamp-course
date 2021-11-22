package com.kodilla.exception.nullpointer;

public class MessageSender {

    public void sendMessangeTo(User user, String message) throws MessageNotSentException {
        if (user != null) {
            System.out.println("Sending message: '" + message + "' To: " + user.getName());
        } else {
            throw new MessageNotSentException("Object User was null");
        }
    }
}
