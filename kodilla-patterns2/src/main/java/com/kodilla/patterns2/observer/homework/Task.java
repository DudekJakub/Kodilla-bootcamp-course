package com.kodilla.patterns2.observer.homework;

import java.util.Objects;

public class Task {

    private final String taskName;
    private final int taskId;
    private final String taskDescription;
    private final Student student;
    private boolean isVerified;
    private boolean isMistake;

    public Task(Student student, String taskName, int taskId, String taskDescription) {
        this.student = student;
        this.taskName = taskName;
        this.taskId = taskId;
        this.taskDescription = taskDescription;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public Student getStudent() {
        return student;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public boolean isMistake() {
        return isMistake;
    }

    public void setMistake(boolean mistake) {
        isMistake = mistake;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return taskName.equals(task.taskName) && taskDescription.equals(task.taskDescription) && student.equals(task.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskName, taskDescription, student);
    }
}
