package jpa.mapping.embedded;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

@Entity
public class EmployeeWithComplexEmbedded {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer     id;
    String      name;
    Long        salary;

    @OneToOne
    ContactInfo contactInfo;

    public EmployeeWithComplexEmbedded(String name, Long salary) {
        super();
        this.name = name;
        this.salary = salary;
    }

    public EmployeeWithComplexEmbedded() {
        super();
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

    public Integer getId() {
        return id;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

}
