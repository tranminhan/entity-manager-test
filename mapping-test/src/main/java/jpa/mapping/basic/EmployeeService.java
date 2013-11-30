package jpa.mapping.basic;

import java.util.Collection;

public interface EmployeeService {
	EmployeeBasic createEmployee(int id, String name, long salary);

	Collection<EmployeeBasic> findAllEmployees();

	EmployeeBasic findEmployee(int id);
	
	void removeEmployee(EmployeeBasic employeeBasic);
}
