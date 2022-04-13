package com.kodilla.patterns.singleton.newSingleton;

public enum EnumSingleton {

    INSTANCE;

    private String name;

    EnumSingleton() {
        System.out.println("This is Singleton based on ENUM!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
