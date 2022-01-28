package com.kodilla.patterns2.observer.homework;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Builder
public class Student implements Observer {

    private final String studentName;
    private final personSex sex;
    private final List<Task> tasks;
    private Mentor mentor;
    private int updateCount;

    public Student(final String studentName, final personSex sex, final List<Task> tasks, Mentor mentor, int updateCount) {
        this.studentName = studentName;
        this.sex = sex;
        this.tasks = new ArrayList<>();
        this.mentor = mentor;
    }

    @Override
    public void update(KodillaCourse kodillaCourse) {
        long taskChecked = kodillaCourse.getTasks().stream()
                .filter(t -> t.getStudent().equals(this))
                .filter(Task::isVerified)
                .count();
        if (taskChecked > 0 && this.sex.equals(personSex.MALE)) {
            System.out.println(studentName + " has " + taskChecked + " task(s) checked by his mentor!");
        } else if ((taskChecked > 0 && this.sex.equals(personSex.FEMALE))) {
            System.out.println(studentName + " has " + taskChecked + " task(s) checked by her mentor!");
        }
        updateCount++;
    }

    public Task createTask(String taskName, String taskDescription) {
        if (tasks.stream().noneMatch(t -> t.getTaskName().equals(taskName))) {
            long taskId = 1;
            if (tasks.size() > 1) {
                taskId = tasks.get(tasks.size() - 1).getTaskId() + 1;
            }
            Task task = new Task(this, taskName, (int) taskId, taskDescription);
            tasks.add(task);
            return task;
        }
        return null;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public personSex getSex() {
        return sex;
    }

    public int getUpdateCount() {
        return updateCount;
    }

    public void setMentor(Mentor mentor) {
        mentor.getStudents().add(this);
        this.mentor = mentor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentName.equals(student.studentName) && tasks.equals(student.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName, tasks);
    }
}
