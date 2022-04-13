package com.kodilla.hibernate.task.dal_with_dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

@NoArgsConstructor
public class TaskDao implements TaskDaoRepository<Task, Integer> {

    private Session currentSession;

    private Transaction currentTransaction;

    public Session openCurrentSession() throws IOException {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() throws IOException {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() throws IOException {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(Task.class);
        configuration.addAnnotatedClass(TaskFinancialDetails.class);
        configuration.addAnnotatedClass(TaskList.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        return configuration.buildSessionFactory(builder.build());
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    @Override
    public void persist(Task entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Task entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Task findById(Integer id) {
        return getCurrentSession().get(Task.class, id);
    }

    @Override
    public void delete(Task entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Task> findAll() {
        return (List<Task>) getCurrentSession().createQuery("from kodilla_course.tasks").list();
    }

    @Override
    public void deleteAll() {
        List<Task> entityList = findAll();
        for (Task task : entityList) {
            delete(task);
        }
    }
}
