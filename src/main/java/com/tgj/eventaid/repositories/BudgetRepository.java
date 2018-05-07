package com.tgj.eventaid.repositories;

import com.tgj.eventaid.models.Budget;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends CrudRepository<Budget, Long>{

}