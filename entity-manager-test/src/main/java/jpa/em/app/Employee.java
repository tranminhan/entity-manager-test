package jpa.em.app;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.TableGenerator;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Entity
@EntityListeners({ EmployeeDebugListener.class })
public class Employee {
    @Id
    @TableGenerator(name = "Emp_Gen",
            table = "ID_TABLE",
            pkColumnName = "ID_NAME",
            valueColumnName = "ID_VALUE",
            allocationSize = 1)
    @GeneratedValue(generator = "Emp_Gen")
    Integer id;

    @NotNull
    String  name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    Address address;

    Long    salary;
    
    @Version
    Integer version;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @PrePersist
    public void prePersist() {
        System.out.println("PrePersist: " + ReflectionToStringBuilder.toString(this));
    }

    @PostPersist
    public void postPersist() {
        System.out.println("PostPersist: " + ReflectionToStringBuilder.toString(this));
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println("PreUpdate: " + ReflectionToStringBuilder.toString(this));
    }

    @PostUpdate
    public void postUpdate() {
        System.out.println("PostUpdate: " + ReflectionToStringBuilder.toString(this));
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Integer getVersion() {
        return version;
    }
}
