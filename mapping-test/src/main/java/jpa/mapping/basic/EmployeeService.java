package jpa.mapping.basic;

import java.util.Collection;

public interface EmployeeService {
	public Employee createEmployee(int id, String name, long salary);

	public Collection<Employee> findAllEmployees();

	public Employee findEmployee(int id);
}
