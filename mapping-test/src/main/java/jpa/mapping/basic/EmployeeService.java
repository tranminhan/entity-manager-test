package jpa.mapping.basic;

import java.util.Collection;

public interface EmployeeService {
	public EmployeeBasic createEmployee(int id, String name, long salary);

	public Collection<EmployeeBasic> findAllEmployees();

	public EmployeeBasic findEmployee(int id);
}
