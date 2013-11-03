package jpa.mapping.relationship.jointable;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

import jpa.mapping.relationship.Department;
import jpa.mapping.relationship.EmployeeWithRelationship;
import jpa.mapping.relationship.ParkingSpace;

@Entity
public class EmployeeWithMultipleDepartments {
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

    public EmployeeWithMultipleDepartments() {
    }

    public EmployeeWithMultipleDepartments(String name, Long salary) {
        super();
        this.name = name;
        this.salary = salary;
    }

    public void addDepartment(DepartmentWithMultipleEmployees department) {
        if (departments == null) {
            departments = new ArrayList<DepartmentWithMultipleEmployees>();
        }
        departments.add(department);
    }

    public void addPhone(Phone phone) {
        if (phones == null) {
            phones = new ArrayList<Phone>();
        }
        phones.add(phone);
    }

    @ManyToMany
    // (cascade = { CascadeType.PERSIST })
    @JoinTable(
            name = "EMP_DEP",
            joinColumns = @JoinColumn(name = "EMP_ID"),
            inverseJoinColumns = @JoinColumn(name = "DEP_ID"))
    Collection<DepartmentWithMultipleEmployees> departments;

    @OneToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY)
    Collection<Phone>                           phones;

    public Collection<Phone> getPhones() {
        return phones;
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

    public Collection<DepartmentWithMultipleEmployees> getDepartments() {
        return departments;
    }

    public void setDepartments(Collection<DepartmentWithMultipleEmployees> departments) {
        this.departments = departments;
    }

    public Integer getId() {
        return id;
    }

}
