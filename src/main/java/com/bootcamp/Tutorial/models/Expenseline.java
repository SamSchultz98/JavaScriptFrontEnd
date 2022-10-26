package com.bootcamp.Tutorial.models;

import javax.persistence.*;



import antlr.collections.List;

@Entity
@Table(name="Expenselines")
public class Expenseline {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private int quantity = 1;
	
//	@JsonManagedReference
//	@ManyToOne(optional=false)
//	@JoinColumn(name="expenseid", columnDefinition="int")
//	private Expense expense;
//	
//	
//	@ManyToOne(optional=false)
//	@JoinColumn(name="itemid", columnDefinition="int")
//	private Item item;
	
	
	@ManyToOne(optional=false)
	@JoinColumn(name="itemid", columnDefinition="int")
	private Item item;
	
	
	@ManyToOne(optional=false)
	@JoinColumn(name="expenseid", columnDefinition="int")
	private Expense expense;

	
	public Expenseline() {}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Expense getExpense() {
		return expense;
	}

	public void setExpense(Expense expense) {
		this.expense = expense;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	

}
