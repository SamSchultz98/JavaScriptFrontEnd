package com.bootcamp.Tutorial.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bootcamp.Tutorial.Repository.EmployeeRepository;
import com.bootcamp.Tutorial.Repository.ExpenseRepository;
import com.bootcamp.Tutorial.models.Expense;

@CrossOrigin
@RestController
@RequestMapping("/api/expenses")
public class ExpensesController {
	
	@Autowired
	private ExpenseRepository expRepo;
	
	@Autowired
	private EmployeeRepository emp1Repo;
	
	
	@GetMapping
	public ResponseEntity<Iterable<Expense>> getExpenses(){
		var target = expRepo.findAll();
		return new ResponseEntity<Iterable<Expense>>(target,HttpStatus.FOUND);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Expense> getExpensebyId(@PathVariable int id){
		var target = expRepo.findById(id);
		if(target.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Expense>(target.get(), HttpStatus.FOUND);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity deleteExpense(@PathVariable int id) {
		var target = expRepo.findById(id);
		if (target.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		expRepo.delete(target.get());
		return new ResponseEntity<Expense>(HttpStatus.ACCEPTED);
		
	}
	
	@PostMapping
	public ResponseEntity<Expense> createExpense(@RequestBody Expense expense){
		if(expense.getId()!=0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		expRepo.save(expense);
		return new ResponseEntity<Expense>(expense,HttpStatus.CREATED);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Expense> updateExpense(@PathVariable int id, @RequestBody Expense expense){
		if(expense.getId() != id) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		expRepo.save(expense);
		return new ResponseEntity<>(expense,HttpStatus.ACCEPTED);
		
	}
	
	//Custom Methods
	
	
//	change the status of the expense to "PAID" and
//	add the expense total to the employee's ExpensesPaid and
//	subtract the expense total from the employee's ExpensesDue.
//	
	//PayExpense (PUT)
	//Path is /api/expenses/pay/{expenseid}
//	
//	@PutMapping("pay/{expenseid}")
//	public ResponseEntity<Expense> payExpense(@PathVariable int expenseid, Expense expense) 	
		
	
	@PutMapping("reject/{id}")
	public ResponseEntity<Expense> rejectExpense(@PathVariable int id){
		var target = expRepo.findById(id);
		if(target.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		var targetExp=target.get();
		targetExp.setStatus("REJECTED");
		return new ResponseEntity<Expense>(targetExp,HttpStatus.ACCEPTED);
		
	}
	
//	@PutMapping("{id}")
//	public ResponseEntity<Expense> approveExpense(@PathVariable int id){
//		var target = expRepo.findById(id).get();
//		target.setStatus("APPROVED");
//		//add the balance due to balance paid
//		
//	}		//emp1Repo
	
	@PutMapping("pay/{id}")
	public ResponseEntity<Expense> payExpense(@PathVariable int id){
		var target = expRepo.findById(id);
		if(target.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		var targetEmp = target.get().getEmployee();
		var amountPaid = targetEmp.getExpensesdue();
		var totalAmount = targetEmp.getExepensespaid();
//		var totalFromExpense = target.get().getTotal();
		if(targetEmp.getExpensesdue() == 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		targetEmp.setExepensespaid(totalAmount + amountPaid);
		return new ResponseEntity<Expense>(target.get(),HttpStatus.ACCEPTED);
		
	}
	
//	private ResponseEntity<Expense> UpdateEmployeeExpensesDueAndPaid(int empid){
//		var targetEmp = expRepo.findByEmployeeid(empid).getEmployee();
//		var expTotal = expRepo.findByEmployeeid(empid).getTotal();
//		
//		expRepo.findByEmployeeid(empid).setTotal(targetEmp.get);
//			
//	}
	@GetMapping("inreview")
	public ResponseEntity<Iterable<Expense>> getExpensesinReview(){
		var target = expRepo.findAll().;
		var targetStatus = target.
		new ResponseEntity<Iterable<Expense>>(target,HttpStatus.ACCEPTED);
	}

}
