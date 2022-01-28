package com.kodilla.patterns2.observer.forum;

import java.util.ArrayList;
import java.util.List;

public class ForumTopic implements Observable {
    private final List<String> messages;
    private final List<Observer> observers;
    private final String name;

    public ForumTopic(final String name) {
        this.messages = new ArrayList<>();
        this.observers = new ArrayList<Observer>();
        this.name = name;
    }

    public void addPost(String postContent) {
        messages.add(postContent);
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers)
            observer.update(this);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public List<String> getMessages() {
        return messages;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public String getName() {
        return name;
    }
}
