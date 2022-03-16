package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

@SpringBootTest
public class KodillaCourseTestSuite {

    private KodillaCourse kodillaCourse;
    private Mentor piotrMentor;
    private Mentor adamMentor;
    private Student jakubStudent;
    private Student bartoszStudent;

    void makeMultipleTasksAdded(Task... tasks) {
        for (Task task : tasks) {
            kodillaCourse.addTask(task);
        }
    }

    void makeMultipleTasksVerified(Task... tasks) {
        for (Task task : tasks) {
            kodillaCourse.makeTaskVerified(task);
        }
    }

    @BeforeEach
    void setStartSetting() {
        kodillaCourse = new KodillaCourse("Kodilla_Course");
        piotrMentor = Mentor.builder().mentorName("Piotr Kowalski").sex(personSex.MALE).build();
        adamMentor = Mentor.builder().mentorName("Adam Kaczmarek").sex(personSex.MALE).build();
        jakubStudent = Student.builder()
                .studentName("Jakub Dudek")
                .sex(personSex.MALE)
                .build();
        bartoszStudent = Student.builder()
                .studentName("Bartosz Smerek")
                .sex(personSex.MALE)
                .build();
        jakubStudent.setMentor(piotrMentor);
        bartoszStudent.setMentor(adamMentor);
    }

    @Test
    public void testUpdateMentor() {
        //Given
            //setStartSetting()

        //When
        kodillaCourse.registerObserver(piotrMentor);
        kodillaCourse.registerObserver(adamMentor);

        try {
            Task task = jakubStudent.createTask("6.1 Task: use stream", "Learning stream");
            Task task1 = jakubStudent.createTask("6.2 Task: use pattern A", "Learning pattern A");
            Task task2 = jakubStudent.createTask("6.3 Task: use pattern B", "Learning pattern B");
            Task task3 = bartoszStudent.createTask("10.5 Task: use Rest-API", "Learning Rest-API");
            Task task4 = jakubStudent.createTask("6.1 Task: use stream", "Learning stream");

            makeMultipleTasksAdded(task, task1, task2, task3, task4);

        } catch (Exception e) {
            System.out.print("\nError occured while creating or adding tasks: \n" + Arrays.toString(e.getStackTrace()));
        }

        //Then
        Assertions.assertEquals(3, piotrMentor.getUpdateCount());
        Assertions.assertEquals(1, adamMentor.getUpdateCount());
    }

    @Test
    void testStudentGetTasks() {
        //Given
            //setStartSetting()

        //When
        kodillaCourse.registerObserver(piotrMentor);
        kodillaCourse.registerObserver(adamMentor);

        try {
            Task task = jakubStudent.createTask("6.1 Task: use stream", "Learning stream");
            Task task1 = jakubStudent.createTask("6.2 Task: use pattern A", "Learning pattern A");
            Task task2 = jakubStudent.createTask("6.3 Task: use pattern B", "Learning pattern B");
            Task task3 = bartoszStudent.createTask("10.5 Task: use Rest-API", "Learning Rest-API");
            Task task4 = jakubStudent.createTask("6.1 Task: use stream", "Learning stream");

            makeMultipleTasksAdded(task, task1, task2, task3, task4);
        } catch (Exception e) {
            System.out.print("\nError occured while creating or adding tasks: \n" + Arrays.toString(e.getStackTrace()));
        }

        int jakubStudentTasksQuantity = jakubStudent.getTasks().size();
        int bartoszStudentTasksQuantity = bartoszStudent.getTasks().size();

        //Then
        assertEquals(3, jakubStudentTasksQuantity);
        assertEquals(1, bartoszStudentTasksQuantity);
    }

    @Test
    void testMentorGetStudents() {
        //Given
            //setStartSetting() +
        Student martynaStudent = Student.builder()
                .studentName("Martyna Bykowska")
                .sex(personSex.FEMALE)
                .build();
        Mentor kasiaMentor = Mentor.builder().mentorName("Kasia Skrzypczak").sex(personSex.FEMALE).build();
        martynaStudent.setMentor(piotrMentor);


        //When
        kodillaCourse.registerObserver(piotrMentor);
        kodillaCourse.registerObserver(adamMentor);
        kodillaCourse.registerObserver(kasiaMentor);

        try {
            Task task = jakubStudent.createTask("6.1 Task: use stream", "Learning stream");
            Task task1 = jakubStudent.createTask("6.2 Task: use pattern A", "Learning pattern A");
            Task task2 = jakubStudent.createTask("6.3 Task: use pattern B", "Learning pattern B");
            Task task3 = bartoszStudent.createTask("10.5 Task: use Rest-API", "Learning Rest-API");

            makeMultipleTasksAdded(task, task1, task2, task3);
        } catch (Exception e) {
            System.out.print("\nError occured while creating or adding tasks: \n" + Arrays.toString(e.getStackTrace()));
        }

        int piotrMentorStudentsQuantity = piotrMentor.getStudents().size();
        int kasiaMentorStudentsQuantity = kasiaMentor.getStudents().size();

        //Then
        assertEquals(2, piotrMentorStudentsQuantity);
        assertEquals(0, kasiaMentorStudentsQuantity);
    }

    @Test
    void testUpdateStudent() {
        //Given
            //setStartSetting()

        Student martynStudent = Student.builder().studentName("Martyna Bykowska").sex(personSex.FEMALE).build();
        martynStudent.setMentor(adamMentor);

        //When
        kodillaCourse.registerObserver(piotrMentor);
        kodillaCourse.registerObserver(adamMentor);
        kodillaCourse.registerObserver(jakubStudent);
        kodillaCourse.registerObserver(bartoszStudent);
        kodillaCourse.registerObserver(martynStudent);

        try {
            Task task = jakubStudent.createTask("6.1 Task: use stream", "Learning stream");
            Task task1 = jakubStudent.createTask("6.2 Task: use pattern A", "Learning pattern A");
            Task task2 = jakubStudent.createTask("6.3 Task: use pattern B", "Learning pattern B");
            Task task3 = bartoszStudent.createTask("10.5 Task: use Rest-API", "Learning Rest-API");
            Task task4 = martynStudent.createTask("22,1 Task: use lombok builder", "Learning annotations");

            makeMultipleTasksAdded(task, task1, task2, task3, task4);

            makeMultipleTasksVerified(task, task1, task3, task4);
        } catch (Exception e) {
            System.out.print("\nError occured while creating or adding tasks: \n" + Arrays.toString(e.getStackTrace()));
        }

        //Then
        assertEquals(2, jakubStudent.getUpdateCount());
        assertEquals(1, bartoszStudent.getUpdateCount());
        assertEquals(1, martynStudent.getUpdateCount());
    }
}
