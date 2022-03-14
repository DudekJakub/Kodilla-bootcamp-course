package com.kodilla.patterns2.observer.homework;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
@EnableAspectJAutoProxy
public class KodillaCourse implements ObservableKodillaCourse {

    private String queueName;
    private List<Observer> observers;
    private List<Task> tasks;

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
