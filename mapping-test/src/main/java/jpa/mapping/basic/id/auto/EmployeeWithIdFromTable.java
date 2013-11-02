package jpa.mapping.basic.id.auto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class EmployeeWithIdFromTable {

    @Id
    @TableGenerator(name = "Emp_Gen",
            table = "ID_TABLE",
            pkColumnName = "ID_NAME",
            valueColumnName = "ID_VALUE",
            allocationSize = 1)
    @GeneratedValue(generator = "Emp_Gen")
    Integer id;

    String  name;

    Long    salary;

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
