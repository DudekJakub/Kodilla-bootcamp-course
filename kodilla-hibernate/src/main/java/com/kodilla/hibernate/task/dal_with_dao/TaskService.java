package com.kodilla.hibernate.task.dal_with_dao;

import com.kodilla.hibernate.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TaskService {

    public static TaskDao taskDao;

    @Autowired
    public TaskService() {
        taskDao = new TaskDao();
    }

    public void persist(Task entity) throws IOException {
        taskDao.openCurrentSessionWithTransaction();
        taskDao.persist(entity);
        taskDao.closeCurrentSessionWithTransaction();
    }

    public void update(Task entity) throws IOException {
        taskDao.openCurrentSessionWithTransaction();
        taskDao.update(entity);
        taskDao.closeCurrentSessionWithTransaction();
    }

    public Task findById(Integer id) throws IOException {
        taskDao.openCurrentSession();
        Task task = taskDao.findById(id);
        taskDao.closeCurrentSession();
        return task;
    }

    public void delete(Integer id) throws IOException {
        taskDao.openCurrentSessionWithTransaction();
        Task task = taskDao.findById(id);
        taskDao.delete(task);
        taskDao.closeCurrentSessionWithTransaction();
    }

    public List<Task> findAll() throws IOException {
        taskDao.openCurrentSession();
        List<Task> tasks = taskDao.findAll();
        taskDao.closeCurrentSession();
        return tasks;
    }

    public void deleteAll() throws IOException {
        taskDao.openCurrentSessionWithTransaction();
        taskDao.deleteAll();
        taskDao.closeCurrentSessionWithTransaction();
    }

    public TaskDao getTaskDao() {
        return taskDao;
    }
}
