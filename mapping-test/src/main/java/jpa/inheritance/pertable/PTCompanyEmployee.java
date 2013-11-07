package jpa.inheritance.pertable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class PTCompanyEmployee extends PTEmployee {
    Integer vacation;
    
    public PTCompanyEmployee() {
        super();
    }


    public PTCompanyEmployee(String name) {
        super(name);
    }

    public Integer getVacation() {
        return vacation;
    }

    public void setVacation(Integer vacation) {
        this.vacation = vacation;
    }
}
