package jpa.mapping.collection.map;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.TableGenerator;

@Entity
public class EmployeeWithMapOfPhones {
    @Id
    @TableGenerator(name = "Emp_Gen",
            table = "ID_TABLE",
            pkColumnName = "ID_NAME",
            valueColumnName = "ID_VALUE",
            allocationSize = 1)
    @GeneratedValue(generator = "Emp_Gen")
    Integer             id;
    String              name;
    Long                salary;

    @ElementCollection
    @MapKeyColumn(name="PHONE_TYPE")
    @Column(name="PHONE_NUM")
    Map<String, String> phoneNumbers;

    public void addPhoneNumber(String type, String number) {
        if (phoneNumbers == null) {
            phoneNumbers = new HashMap<String, String>();
        }
        phoneNumbers.put(type, number);
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

    public EmployeeWithMapOfPhones(String name, Long salary) {
        super();
        this.name = name;
        this.salary = salary;
    }

    public EmployeeWithMapOfPhones() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public Map<String, String> getPhoneNumbers() {
        return phoneNumbers;
    }

}
