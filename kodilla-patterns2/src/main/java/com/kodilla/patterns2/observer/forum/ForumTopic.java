package com.kodilla.patterns2.observer.forum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class ForumTopic implements Observable {

    protected final static Logger log = LoggerFactory.getLogger(ForumTopic.class);

    private final List<String> messages;
    private final List<Observer> observers;
    protected final List<ForumUser> members;
    private final String name;

    protected ForumUserValidator userValidator = new ForumUserValidator();

    public ForumTopic(final String name) {
        this.messages = new ArrayList<>();
        this.observers = new ArrayList<Observer>();
        this.members = new ArrayList<>();
        this.name = name;
    }

    public void addPost(String postContent) {
        messages.add(postContent);
        notifyObserver();
    }

    protected abstract void addMemberToTopic(ForumUser forumUser);

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
