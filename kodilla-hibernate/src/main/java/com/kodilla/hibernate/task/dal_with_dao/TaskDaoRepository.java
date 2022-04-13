package com.kodilla.hibernate.task.dal_with_dao;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface TaskDaoRepository<T, Id extends Serializable> {

    void persist(T entity);

    void update(T entity);

    T findById(Id id);

    void delete(T entity);

    List<T> findAll();

    void deleteAll();
}
