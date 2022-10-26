package com.bootcamp.Tutorial.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bootcamp.Tutorial.Repository.EmployeeRepository;
import com.bootcamp.Tutorial.models.Employee;

@CrossOrigin
@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	
	@GetMapping
	public ResponseEntity<Iterable<Employee>> getAllEmployees() {
		var target = empRepo.findAll();
		return new ResponseEntity<Iterable<Employee>>(target,HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeebyId(@PathVariable int id){
		var target = empRepo.findById(id);
		if(target.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(target.get(),HttpStatus.FOUND);
		
		
	}
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		if (employee.getId() != 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		empRepo.save(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody Employee employee) {
		var target = empRepo.findById(id);
		if(id != employee.getId()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		empRepo.save(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity deleteEmployee(@PathVariable int id) {
		var target = empRepo.findById(id);
		if(target.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		empRepo.delete(target.get());
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
		
		
	}
	
	//custom method: login
	@GetMapping("{username}/{password}")
	public ResponseEntity<List<Employee>> loginEmployee(@PathVariable String username, @PathVariable String password) {
	var target = empRepo.findByNameAndPassword(username, password);
	return new ResponseEntity<List<Employee>>(target,HttpStatus.FOUND);
			
	}
	
	
	
}
