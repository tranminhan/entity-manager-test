package jpa.inheritance.singletable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class STCompanyEmployee extends STEmployee {
    Integer vacation;
    
    public STCompanyEmployee() {
        super();
    }


    public STCompanyEmployee(String name) {
        super(name);
    }

    public Integer getVacation() {
        return vacation;
    }

    public void setVacation(Integer vacation) {
        this.vacation = vacation;
    }
}
