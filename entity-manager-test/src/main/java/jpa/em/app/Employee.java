package jpa.em.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Employee {
    @Id
    @TableGenerator(name = "Emp_Gen",
            table = "ID_TABLE",
            pkColumnName = "ID_NAME",
            valueColumnName = "ID_VALUE",
            allocationSize = 1)
    @GeneratedValue(generator = "Emp_Gen")
    Integer id;
    String  name;

    public Employee(String name) {
        super();
        this.name = name;
    }

    public Employee() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
