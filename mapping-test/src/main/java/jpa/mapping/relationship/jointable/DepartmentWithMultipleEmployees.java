package jpa.mapping.relationship.jointable;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import jpa.mapping.relationship.EmployeeWithRelationship;

@Entity
public class DepartmentWithMultipleEmployees {
    public DepartmentWithMultipleEmployees() {
    }

    public DepartmentWithMultipleEmployees(String name) {
        super();
        this.name = name;
    }

    public Collection<EmployeeWithMultipleDepartments> getEmployees() {
        return employees;
    }

    @Id
    String                               name;

    public String getName() {
        return name;
    }

    @ManyToMany(mappedBy = "departments")
    Collection<EmployeeWithMultipleDepartments> employees;

    public void addEmployee(EmployeeWithMultipleDepartments employee) {
        if (employees == null) {
            employees = new ArrayList<EmployeeWithMultipleDepartments>();
        }
        employees.add(employee);
        
        employee.addDepartment(this);
    }
}
