package jpa.mapping.relationship;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {

    public Collection<EmployeeWithRelationship> getEmployees() {
        return employees;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Department other = (Department) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        return true;
    }

    public Department(String name) {
        super();
        this.name = name;
    }

    public Department() {
        super();
    }

    @Id
    String                               name;

    @OneToMany(mappedBy = "department")
    Collection<EmployeeWithRelationship> employees;

    public void addEmployee(EmployeeWithRelationship employee) {
        if (employees == null) {
            employees = new ArrayList<EmployeeWithRelationship>();
        }
        employees.add(employee);
        employee.setDepartment(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
