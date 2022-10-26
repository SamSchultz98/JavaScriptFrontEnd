package com.bootcamp.Tutorial.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bootcamp.Tutorial.Repository.ExpenselineRepository;
import com.bootcamp.Tutorial.models.Expenseline;

@CrossOrigin
@RestController
@RequestMapping("/api/expenselines")
public class ExpenselinesController {
	
	@Autowired
	private ExpenselineRepository elRepo;

	@GetMapping
	public ResponseEntity<Iterable<Expenseline>> getExpenselines(){
		return new ResponseEntity<Iterable<Expenseline>>(elRepo.findAll(), HttpStatus.FOUND);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Expenseline> getExpenseline(@PathVariable int id){
		var target = elRepo.findById(id);
		if(target.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Expenseline>(target.get(),HttpStatus.FOUND);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity deleteExpenseline(@PathVariable int id) {
		var target = elRepo.findById(id);
		if(target.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		elRepo.delete(target.get());
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Expenseline> updateExpenseline(@PathVariable int id, @RequestBody Expenseline expenseline) {
		if (id != expenseline.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		elRepo.save(expenseline);
		return new ResponseEntity<Expenseline>(expenseline,HttpStatus.ACCEPTED);
		
		
	}
	
	@PostMapping
	public ResponseEntity<Expenseline> createExpenseline(@RequestBody Expenseline expenseline){
		if(expenseline.getId() != 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		elRepo.save(expenseline);
		return new ResponseEntity<Expenseline>(expenseline,HttpStatus.ACCEPTED);
		
	}
	
	
}

