package jpa.mapping.relationship.ordering;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class DepartmentWithListOfEntities {
    @Id
    String                name;

    @OneToMany(mappedBy = "department", cascade = { CascadeType.PERSIST })
    @OrderBy("name")
    List<EmployeeInOrder> employees;

    public DepartmentWithListOfEntities(String name) {
        super();
        this.name = name;
    }

    public DepartmentWithListOfEntities() {
        super();
    }

    public void addEmployee(String name) {
        if (employees == null) {
            employees = new ArrayList<EmployeeInOrder>();
        }
        EmployeeInOrder employeeInOrder = new EmployeeInOrder(name, 0L);
        employees.add(employeeInOrder);
        employeeInOrder.setDeparment(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeInOrder> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeInOrder> employees) {
        this.employees = employees;
    }

}
