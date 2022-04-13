package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.TaskFinancialDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskFinancialDetailsDao extends JpaRepository<TaskFinancialDetails, Integer> {

    List<TaskFinancialDetails> findByPaid(boolean paid);

    @Override
    Optional<TaskFinancialDetails> findById(Integer integer);
}
