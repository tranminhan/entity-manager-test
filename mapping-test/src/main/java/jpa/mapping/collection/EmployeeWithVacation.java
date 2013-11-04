package jpa.mapping.collection;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.TableGenerator;

@Entity
public class EmployeeWithVacation {
    @Id
    @TableGenerator(name = "Emp_Gen",
            table = "ID_TABLE",
            pkColumnName = "ID_NAME",
            valueColumnName = "ID_VALUE",
            allocationSize = 1)
    @GeneratedValue(generator = "Emp_Gen")
    private Integer id;

    public EmployeeWithVacation(String name, Long salary) {
        super();
        this.name = name;
        this.salary = salary;
    }

    public EmployeeWithVacation() {
        super();
    }

    String name;
    Long   salary;

    public Integer getId() {
        return id;
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

    public Collection<VacationEntry> getVacationBookings() {
        return vacationBookings;
    }

    @ElementCollection(targetClass = VacationEntry.class)
    Collection vacationBookings;

    public void bookVacation(VacationEntry booking) {
        if (vacationBookings == null) {
            vacationBookings = new ArrayList<VacationEntry>();
        }
        vacationBookings.add(booking);
    }

    @ElementCollection
    Collection<String> nickNames;

    public Collection<String> getNickNames() {
        return nickNames;
    }

    public void setNickNames(Collection<String> nickNames) {
        this.nickNames = nickNames;
    }

    public void setVacationBookings(Collection vacationBookings) {
        this.vacationBookings = vacationBookings;
    }

    public void addNickname(String nickName) {
        if (nickNames == null) {
            nickNames = new ArrayList<String>();
        }
        nickNames.add(nickName);
    }

    @ElementCollection
    // @CollectionTable(
    // name = "EMP_PHONE",
    // joinColumns = { @JoinColumn(name = "OWNER_ID") })
    private Collection<PhoneAsElement> phones;

    public void addPhone(String number) {
        if (phones == null) {
            phones = new ArrayList<PhoneAsElement>();
        }
        phones.add(new PhoneAsElement(number));
    }
}
