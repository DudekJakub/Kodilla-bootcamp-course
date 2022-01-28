package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class KodillaCourse implements ObservableKodillaCourse {

    private final String queueName;
    private final List<Observer> observers;
    private final List<Task> tasks;

    protected KodillaCourse(final String queueName) {
        this.queueName = queueName;
        this.observers = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        notifyObserverMentor(task);
    }

    public void makeTaskVerified(Task task) {
        task.setVerified(true);
        notifyObserverStudent(task);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserverMentor(Task task) {
        Student student = task.getStudent();
        Mentor mentor = task.getStudent().getMentor();
        for (Observer observer : observers) {
            if(mentor.getStudents().stream().anyMatch(s -> s.equals(student)) && observer.equals(mentor)) {
                observer.update(this);
            }
        }
    }

    @Override
    public void notifyObserverStudent(Task task) {
        Student student = task.getStudent();
        if (task.isVerified()) {
            student.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public String getQueueName() {
        return queueName;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
