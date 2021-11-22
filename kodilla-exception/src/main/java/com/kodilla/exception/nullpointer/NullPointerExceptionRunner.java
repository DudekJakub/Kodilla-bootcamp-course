package com.kodilla.exception.nullpointer;

public class NullPointerExceptionRunner {

    public static void main (String[] args) {

        User user1 = new User("Johny");
        User user2 = null;

        MessageSender messageSender = new MessageSender();

        try {
            messageSender.sendMessangeTo(user1, "Siema");
        } catch (MessageNotSentException e) {
            System.out.println("Messge is not send," + "but my program is still running!");
        }

        try {
            messageSender.sendMessangeTo(user2, "Do zobaczeni!");
        } catch (MessageNotSentException e) {
            System.out.println("Messge is not send," + "but my program is still running!");
        }

        System.out.println("Continue program...");
    }
}
