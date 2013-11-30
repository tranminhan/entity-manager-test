package jpa.mapping.key.derived;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeAsOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String  name;
    Long    salary;

    public EmployeeAsOwner(String name) {
        super();
        this.name = name;
    }

    public EmployeeAsOwner() {
        super();
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
