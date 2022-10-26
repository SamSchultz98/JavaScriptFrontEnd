package com.bootcamp.Tutorial.Repository;

import org.springframework.data.repository.CrudRepository;

import com.bootcamp.Tutorial.models.Expense;
import com.bootcamp.Tutorial.models.Expenseline;

public interface ExpenselineRepository extends CrudRepository<Expenseline,Integer> {

	
}
