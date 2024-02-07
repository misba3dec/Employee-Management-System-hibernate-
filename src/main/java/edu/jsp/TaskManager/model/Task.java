package edu.jsp.TaskManager.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import org.hibernate.annotations.UpdateTimestamp;
@Cacheable
@Entity
public class Task {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq_1")
	@SequenceGenerator(name = "my_seq_1", initialValue = 10, allocationSize = 10, sequenceName = "my_cust_seq1")

	private int Id;
	private String Name;
	@CreationTimestamp
	private LocalDate StartDate;
	private LocalDate DeadLine;

	@ManyToMany(mappedBy = "tasks")
	List<Employee> employees;

	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public LocalDate getStartDate() {
		return StartDate;
	}

	public void setStartDate(LocalDate startDate) {
		StartDate = startDate;
	}

	public LocalDate getDeadLine() {
		return DeadLine;
	}

	public void setDeadLine(LocalDate deadLine) {
		DeadLine = deadLine;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

}