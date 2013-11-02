package jpa.mapping.basic;

import java.util.Collection;

import javax.persistence.EntityManager;

public class EmployeeServiceBean implements EmployeeService {

	EntityManager entityManager;

	public EmployeeServiceBean(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public Employee createEmployee(int id, String name, long salary) {
	    entityManager.getTransaction().begin();
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setSalary(salary);

		entityManager.persist(employee);
		entityManager.getTransaction().commit();

		return employee;
	}

	public Collection<Employee> findAllEmployees() {
		return null;
	}

	public Employee findEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
