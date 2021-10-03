package com.kodilla.stream.portfolio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BoardTestSuite {

    @Test
    void testAddTaskList() {
        //Given
        Board project = prepareTestData();
        //When

        //Then
        Assertions.assertEquals(3, project.getTaskLists().size());
    }

    private Board prepareTestData() {
        //users
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");

        //tasks
        Task task1 = new Task("Microservice for taking temperature", "Write and test the microservie taking\n" + "the temperature from external servie",
                user1, user2, LocalDate.now().minusDays(20), LocalDate.now().plusDays(30));

        Task task2 = new Task("HQLs for analysis", "Prepare some HQL queries for analysis",
                user1, user2, LocalDate.now().minusDays(20), LocalDate.now().minusDays(5));

        Task task3 = new Task("Temperatures entity", "Prepare entity for temperatures",
                user3, user2, LocalDate.now().minusDays(20), LocalDate.now().plusDays(15));

        Task task4 = new Task("Own logger", "Refactor company logger to meet our needs",
                user3, user2, LocalDate.now().minusDays(10), LocalDate.now().plusDays(25));

        Task task5 = new Task("Optimize searching", "Archive data searching has to be optimized",
                user4, user2, LocalDate.now(), LocalDate.now().plusDays(5));

        Task task6 = new Task("Use Streams", "use Streams rather then for-loops in predictions",
                user4, user2, LocalDate.now().minusDays(15), LocalDate.now().plusDays(2));

        //taskLists
        TaskList taskListToDo = new TaskList("To Do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);

        //board
        Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }

    @Test
    void testAddTaskListFindUseresTasks() {
        //Given
        Board project = prepareTestData();

        //When
        User user = new User("developer1", "John Smith");
        List<Task> tasks = project.getTaskLists().stream()
                .flatMap(l -> l.getTasks().stream())
                .filter(t -> t.getAssignedUser().equals(user))
                .collect(Collectors.toList());

        //Then
        Assertions.assertEquals(2, tasks.size());
        Assertions.assertEquals(user, tasks.get(0).getAssignedUser());
        Assertions.assertEquals(user, tasks.get(1).getAssignedUser());

        System.out.println(tasks);
    }

    @Test
    void testAddTaskListFindOutdatedTasks() {
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> undoneTasks = new ArrayList<>();
        undoneTasks.add(new TaskList("To do"));
        undoneTasks.add(new TaskList("In progress"));
        List<Task> tasks = project.getTaskLists().stream()
                .filter(undoneTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .filter(t -> t.getDeadline().isBefore(LocalDate.now()))
                .collect(Collectors.toList());

        //Then
        Assertions.assertEquals(1, tasks.size());
        Assertions.assertEquals("HQLs for analysis", tasks.get(0).getTitle());
    }

    @Test
    void testAddTaskListFindLongTasks() {
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        var longTasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .map(Task::getCreated)
                .filter(d -> d.compareTo(LocalDate.now().minusDays(10)) <= 0)
                .count();

        //Then
        Assertions.assertEquals(2, longTasks);
    }

    @Test
    void testAddTaskListAverageWorkingOnTask() {
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));

        long numberOfTasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .count();

        System.out.println("Liczba zadan = " + numberOfTasks);

        long sumOfDays = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .map(Task::getCreated)
                .map(d -> ChronoUnit.DAYS.between(d, LocalDate.now()))
                .reduce(0L, (sum, current) -> sum + current);

        System.out.println("Suma dni = " + sumOfDays);

        double averageNumberOfDays = sumOfDays / numberOfTasks;
        System.out.println("Srednia liczba dni = " + averageNumberOfDays);

        //Then
        Assertions.assertEquals(3, numberOfTasks);
        Assertions.assertEquals(30, sumOfDays);
        Assertions.assertEquals(10.0, averageNumberOfDays);
    }
}
