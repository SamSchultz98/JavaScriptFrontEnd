package com.bootcamp.Tutorial.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import antlr.collections.List;

@Entity
@Table(name="Expenses")
public class Expense {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=80)
	private String description;
	
	@Column(length=10)
	private String status;
	
	@Column(columnDefinition="decimal (11,2) not NULL DEFAULT 0")
	private double Total;
	

	
	@ManyToOne(optional=false)
	@JoinColumn(name="employeeid", columnDefinition="int")
	private Employee employee;								//FK to employee

@JsonBackReference
@ManyToOne
@JoinColumn(name="expenselineid")
private Expenseline expenselines;
	
	public Expense() {}
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public double getTotal() {
		return Total;
	}



	public void setTotal(double total) {
		Total = total;
	}



	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
	
	
	
	
	
}
