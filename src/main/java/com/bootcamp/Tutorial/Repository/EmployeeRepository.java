package com.bootcamp.Tutorial.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bootcamp.Tutorial.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	 List<Employee> findByNameAndPassword(String username, String password);
	 
	 
}
