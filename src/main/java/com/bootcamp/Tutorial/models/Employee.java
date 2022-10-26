package com.bootcamp.Tutorial.models;

import javax.persistence.*;

@Entity
@Table(name="Employees", uniqueConstraints=@UniqueConstraint(name="UIDX_Email", columnNames={"email"}))
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=30)
	private String name;
	
	@Column(length=50)
	private String email;
	
	@Column(length=30)
	private String password;
	
	
	private boolean admin;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double expensesdue;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double exepensespaid;
	
	
	public Employee() {}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public double getExpensesdue() {
		return expensesdue;
	}
	public void setExpensesdue(double expensesdue) {
		this.expensesdue = expensesdue;
	}
	public double getExepensespaid() {
		return exepensespaid;
	}
	public void setExepensespaid(double exepensespaid) {
		this.exepensespaid = exepensespaid;
	}
	
	

}
