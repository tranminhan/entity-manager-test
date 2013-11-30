package jpa.mapping.key.derived;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class EmployeeHistoryWithRedundantId {

    @Id
    int             empId;

    @OneToOne
    @MapsId
    EmployeeAsOwner employee;

    String          description;

    public String getDescription() {
        return description;
    }

    public EmployeeHistoryWithRedundantId(EmployeeAsOwner employee) {
        super();
        this.employee = employee;
    }

    public EmployeeHistoryWithRedundantId() {
        super();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EmployeeAsOwner getEmployee() {
        return employee;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }
}
