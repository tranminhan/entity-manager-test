package jpa.mapping.key.derived;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class EmployeeHistory {

    @Id
    @OneToOne
    @JoinColumn(name = "EMP_ID")
    EmployeeAsOwner employee;

    String          description;

    public String getDescription() {
        return description;
    }

    public EmployeeHistory(EmployeeAsOwner employee) {
        super();
        this.employee = employee;
    }

    public EmployeeHistory() {
        super();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EmployeeAsOwner getEmployee() {
        return employee;
    }

}
