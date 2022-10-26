package com.bootcamp.Tutorial.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bootcamp.Tutorial.Repository.ItemRepository;
import com.bootcamp.Tutorial.models.Item;

@CrossOrigin
@RestController
@RequestMapping("/api/items")
public class ItemsController {
	
	@Autowired
	public ItemRepository itRepo;
	
	
	@GetMapping
	public ResponseEntity<Iterable<Item>> getItems(){
		return new ResponseEntity<Iterable<Item>>(itRepo.findAll(),HttpStatus.FOUND);		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Item> getItemById(@PathVariable int id){
		var target = itRepo.findById(id);
		if(target.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Item>(target.get(), HttpStatus.FOUND);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity deleteItem(@PathVariable int id) {
		var target = itRepo.findById(id);
		if(target.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		itRepo.delete(target.get());
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PostMapping
	public ResponseEntity<Item> createItem(@RequestBody Item item){
		if(item.getId() != 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		itRepo.save(item);
		return new ResponseEntity<Item>(item, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Item> updateItem(@PathVariable int id, @RequestBody Item item){
		if (id != item.getId()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		itRepo.save(item);
		return new ResponseEntity<Item>(item, HttpStatus.ACCEPTED);
	}

}
