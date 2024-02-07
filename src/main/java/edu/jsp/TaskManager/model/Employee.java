package edu.jsp.TaskManager.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CreationTimestamp;



import org.hibernate.annotations.CreationTimestamp;
@Cacheable
@Entity
public class Employee {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String Name;
	private int Age;
	@CreationTimestamp
	private LocalDate DOJ;
	private double Salary;

	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "emp_id"), inverseJoinColumns = @JoinColumn(name = "task_id"))
	List<Task> tasks;

	
	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public int getAge() {
		return Age;
	}


	public void setAge(int age) {
		Age = age;
	}


	public double getSalary() {
		return Salary;
	}


	public void setSalary(double salary) {
		Salary = salary;
	}


	public List<Task> getTasks() {
		return tasks;
	}


	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}