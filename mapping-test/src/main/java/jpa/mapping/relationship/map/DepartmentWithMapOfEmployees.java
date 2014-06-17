package jpa.mapping.relationship.map;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;

@Entity
public class DepartmentWithMapOfEmployees {
    @Id
    String                         name;

    @OneToMany(mappedBy = "department", cascade = { CascadeType.PERSIST })
    @MapKeyColumn(name = "CUBE_ID")
    Map<String, EmployeeInCubicle> employees;

    public void addEmployee(String cube, EmployeeInCubicle employee) {
        if (employees == null) {
            employees = new HashMap<String, EmployeeInCubicle>();
        }
        employee.setDepartment(this);
        employees.put(cube, employee);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentWithMapOfEmployees(String name) {
        super();
        this.name = name;
    }

    public DepartmentWithMapOfEmployees() {
        super();
    }

    public Map<String, EmployeeInCubicle> getEmployees() {
        return employees;
    }
}
