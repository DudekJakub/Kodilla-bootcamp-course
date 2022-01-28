package com.kodilla.patterns2.observer.homework;

public interface ObservableKodillaCourse {
    void registerObserver(Observer observer);
    void notifyObserverMentor(Task task);
    void notifyObserverStudent(Task task);
    void removeObserver(Observer observer);
}
