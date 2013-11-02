package jpa.mapping.basic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeBasic {
	@Id
	Integer id;

	String name;

	Long salary;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}
}
