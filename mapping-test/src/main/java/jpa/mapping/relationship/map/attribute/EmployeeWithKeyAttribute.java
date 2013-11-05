package jpa.mapping.relationship.map.attribute;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

@Entity
public class EmployeeWithKeyAttribute {
    @Id
    @TableGenerator(name = "Emp_Gen",
            table = "ID_TABLE",
            pkColumnName = "ID_NAME",
            valueColumnName = "ID_VALUE",
            allocationSize = 1)
    @GeneratedValue(generator = "Emp_Gen")
    Integer id;
    String  name;

    public EmployeeWithKeyAttribute() {
        super();
    }

    @ManyToOne
    DepartmentWithMapKeyedByAttribute department;

    public EmployeeWithKeyAttribute(String name) {
        super();
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setDepartment(DepartmentWithMapKeyedByAttribute department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }
}
