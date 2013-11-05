package jpa.mapping.relationship.map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

@Entity
public class EmployeeInCubicle {
    @Id
    @TableGenerator(name = "Emp_Gen",
            table = "ID_TABLE",
            pkColumnName = "ID_NAME",
            valueColumnName = "ID_VALUE",
            allocationSize = 1)
    @GeneratedValue(generator = "Emp_Gen")
    Integer id;

    public EmployeeInCubicle(String name) {
        super();
        this.name = name;
    }

    public EmployeeInCubicle() {
        super();
    }

    String                       name;

    @ManyToOne
    DepartmentWithMapOfEmployees department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentWithMapOfEmployees getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentWithMapOfEmployees department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }
}
