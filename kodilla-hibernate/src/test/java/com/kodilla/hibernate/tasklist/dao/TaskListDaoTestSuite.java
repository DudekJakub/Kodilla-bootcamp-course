package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.task.dao.TaskDao;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Autowired
    private TaskDao taskDao;

    private final String DISCRIPTION = "Here is description example no.1";
    private final String LISTNAME = "ListNameTest";

    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(LISTNAME, DISCRIPTION );

        //When
        taskListDao.save(taskList);

        //Then
        int id = taskList.getId();
        Optional<TaskList> readTaskList = taskListDao.findById(id);

        String taskListFind = taskList.getListName();
        List<TaskList> taskListFindResult = taskListDao.findByListName(taskListFind);

        Assertions.assertTrue(readTaskList.isPresent());
        Assertions.assertEquals(1, taskListFindResult.size());

        //CleanUp
        taskListDao.deleteById(id);
    }

    @Test
    void testTaskListDaoSaveWithTasks() {
        //Given
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task1 = new Task("Test: Write some entities", 3);

        TaskFinancialDetails tft = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tft2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tft);
        task1.setTaskFinancialDetails(tft2);

        TaskList taskList = new TaskList(LISTNAME, "ToDo tasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task1);

        task.setTaskList(taskList);
        task1.setTaskList(taskList);

        //When
        taskListDao.save(taskList);
        int id = taskList.getId();
        taskDao.saveAll(Arrays.asList(task, task1));
        int task_Id = taskDao.findByDuration(14).get(0).getId();
        int task1_Id = taskDao.findByDuration(3).get(0).getId();

        //Then
        Assertions.assertNotEquals(0, id);

        //CleanUp
        taskListDao.deleteById(id);
        taskDao.deleteById(task_Id);
        taskDao.deleteById(task1_Id);
    }
}
