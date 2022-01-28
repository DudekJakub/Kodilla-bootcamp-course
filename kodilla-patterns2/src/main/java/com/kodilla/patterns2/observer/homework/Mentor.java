package com.kodilla.patterns2.observer.homework;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class Mentor implements Observer {
    private final String mentorName;
    private final personSex sex;
    private int updateCount;
    private final List<Student> students;

    public Mentor(final String mentorName, final personSex sex, int updateCount, final List<Student> students) {
        this.mentorName = mentorName;
        this.sex = sex;
        this.students = new ArrayList<>();
    }

    @Override
    public void update(KodillaCourse kodillaCourse) {
        long tasksToCheck = kodillaCourse.getTasks().stream().filter(t -> t.getStudent().getMentor().getMentorName().equals(mentorName)).count();
        System.out.println(mentorName + " has " + tasksToCheck + " task(s) to check");
        updateCount++;
    }

    public String getMentorName() {
        return mentorName;
    }

    public int getUpdateCount() {
        return updateCount;
    }

    public List<Student> getStudents() {
        return students;
    }

    public personSex getSex() {
        return sex;
    }
}
