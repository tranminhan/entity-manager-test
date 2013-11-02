package jpa.mapping.relationship;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

@Entity
public class EmployeeWithRelationship {
    @Id
    @TableGenerator(name = "Emp_Gen",
            table = "ID_TABLE",
            pkColumnName = "ID_NAME",
            valueColumnName = "ID_VALUE",
            allocationSize = 1)
    @GeneratedValue(generator = "Emp_Gen")
    Integer    id;
    String     name;
    Long       salary;

    @ManyToOne(cascade = { CascadeType.PERSIST })
    Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
