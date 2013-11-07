package jpa.inheritance.jointable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class JTCompanyEmployee extends JTEmployee {
    Integer vacation;
    
    public JTCompanyEmployee() {
        super();
    }


    public JTCompanyEmployee(String name) {
        super(name);
    }

    public Integer getVacation() {
        return vacation;
    }

    public void setVacation(Integer vacation) {
        this.vacation = vacation;
    }
}
