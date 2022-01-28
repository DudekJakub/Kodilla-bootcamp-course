package com.kodilla.patterns2.observer.homework;

public enum personSex {

    MALE("MALE"),
    FEMALE("FEMALE");

    private final String sex;

    personSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }
}
