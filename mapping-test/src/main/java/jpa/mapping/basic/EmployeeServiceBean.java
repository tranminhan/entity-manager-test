package jpa.mapping.basic;

import java.util.Collection;

import javax.persistence.EntityManager;

public class EmployeeServiceBean implements EmployeeService {

	EntityManager entityManager;

	public EmployeeServiceBean(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public EmployeeBasic createEmployee(int id, String name, long salary) {
	    entityManager.getTransaction().begin();
		EmployeeBasic employee = new EmployeeBasic();
		employee.setId(id);
		employee.setName(name);
		employee.setSalary(salary);

		entityManager.persist(employee);
		entityManager.getTransaction().commit();

		return employee;
	}

	public Collection<EmployeeBasic> findAllEmployees() {
		return null;
	}

	public EmployeeBasic findEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

    public void removeEmployee(EmployeeBasic employeeBasic) {
        entityManager.getTransaction().begin();        
        entityManager.refresh(employeeBasic);
        entityManager.getTransaction().commit();        
    }

}
