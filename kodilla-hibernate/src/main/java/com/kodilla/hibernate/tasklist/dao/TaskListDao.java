package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskListDao extends JpaRepository<TaskList, Integer> {
    List<TaskList> findByListName(String listName);

    @Override
    Optional<TaskList> findById(Integer integer);

    @Override
    default <S extends TaskList> S saveAndFlush(S entity) {
        return null;
    }
}
