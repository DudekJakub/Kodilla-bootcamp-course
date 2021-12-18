package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

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
}
