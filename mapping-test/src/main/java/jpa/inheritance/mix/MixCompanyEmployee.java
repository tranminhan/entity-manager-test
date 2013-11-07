package jpa.inheritance.mix;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class MixCompanyEmployee extends MixEmployee {
    Integer vacation;

    public MixCompanyEmployee() {
        super();
    }

    public MixCompanyEmployee(String name) {
        super(name);
    }

    public Integer getVacation() {
        return vacation;
    }

    public void setVacation(Integer vacation) {
        this.vacation = vacation;
    }
}
