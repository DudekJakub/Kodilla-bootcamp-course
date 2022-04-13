package com.kodilla.patterns.singleton.newSingleton;

public class NewSingleton {

    public static NewSingleton instance = null;
    public String name;

    private NewSingleton() {
        System.out.println("This new SINGLETON has been initialized!");
    }

    public static NewSingleton getInstance() {

        if (instance == null) {
            instance = new NewSingleton();
        }
        return instance;
    }

    //IMPLEMENTACJA JAKIEGOKOLWIEK KODU, NP. POLACZENIA Z BAZĄ DANYCH, LOGOWANIA LOGÓW, LOGOWANIA USERÓW ITD.
}
