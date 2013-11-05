package jpa.mapping.collection.map;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.TableGenerator;

@Entity
public class EmployeeWithMapEnumeratedKey {
    @Id
    @TableGenerator(name = "Emp_Gen",
            table = "ID_TABLE",
            pkColumnName = "ID_NAME",
            valueColumnName = "ID_VALUE",
            allocationSize = 1)
    @GeneratedValue(generator = "Emp_Gen")
    Integer                id;
    public EmployeeWithMapEnumeratedKey(String name, Long salary) {
        super();
        this.name = name;
        this.salary = salary;
    }

    public EmployeeWithMapEnumeratedKey() {
        super();
    }

    String                 name;
    Long                   salary;

    @ElementCollection
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "PHONE_TYPE")
    @Column(name = "PHONE_NUM")
    Map<PhoneType, String> phoneNumbers;

    public void addPhoneNumber(PhoneType type, String number) {
        if (phoneNumbers == null) {
            phoneNumbers = new HashMap<PhoneType, String>();
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

    public Integer getId() {
        return id;
    }

    public Map<PhoneType, String> getPhoneNumbers() {
        return phoneNumbers;
    }
}
