package com.kodilla.exception.nullpointer;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        User user = new User("Jackob");

        Optional<User> optionalUser = Optional.ofNullable(user);

        String username = optionalUser.orElse(new User("...")).getName();

        optionalUser.ifPresent(u -> System.out.println(u.getName()));

        System.out.println(username);
    }
}
