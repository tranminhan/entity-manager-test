package jpa.mapping.relationship.map.attribute;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class DepartmentWithMapKeyedByAttribute {
    @Id
    String                                 name;

    @OneToMany(mappedBy = "department", cascade = { CascadeType.PERSIST })
    @MapKey(name = "id")
    Map<Integer, EmployeeWithKeyAttribute> employees;

    public void addEmployee(EmployeeWithKeyAttribute employee) {
        if (employees == null) {
            employees = new HashMap<Integer, EmployeeWithKeyAttribute>();
        }
        employee.setDepartment(this);
        employees.put(employee.getId(), employee);
    }

    public String getName() {
        return name;
    }

    public DepartmentWithMapKeyedByAttribute(String name) {
        super();
        this.name = name;
    }

    public DepartmentWithMapKeyedByAttribute() {
        super();
    }

    public Map<Integer, EmployeeWithKeyAttribute> getEmployees() {
        return employees;
    }

}
