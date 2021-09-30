package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final int userId;
    private final String userName;
    private final char userSex;
    private final LocalDate birthDate;
    private final int userPostQuantity;

    public ForumUser(final int userId, final String userName, final char userSex, final int yearOfBirth, final int monthOfBirth, final int dayOfBirth, final int userPostQuantity) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.birthDate = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        this.userPostQuantity = userPostQuantity;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public char getUserSex() {
        return userSex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getUserPostQuantity() {
        return userPostQuantity;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "ID = " + userId +
                ", Name = '" + userName + '\'' +
                ", Sex = " + userSex +
                ", BirthDay = " + birthDate +
                ", PostCounter = " + userPostQuantity +
                '}';
    }
}
