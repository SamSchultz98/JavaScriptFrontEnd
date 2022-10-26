package com.bootcamp.Tutorial.Repository;
import org.springframework.data.repository.CrudRepository;

import com.bootcamp.Tutorial.models.Expense;

public interface ExpenseRepository extends CrudRepository<Expense,Integer> {

	Expense findByEmployeeid(int id);
	Expense findAllByStatus(String status);

}
