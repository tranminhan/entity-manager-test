package jpa.inheritance.jointable;

import javax.persistence.Entity;

@Entity
public class JTContractEmployee extends JTEmployee {
    Integer dailyRate;
    Integer term;

    public JTContractEmployee() {
    }

    public JTContractEmployee(String name, Integer dailyRate) {
        super(name);
        this.dailyRate = dailyRate;
    }

    public Integer getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(Integer dailyRate) {
        this.dailyRate = dailyRate;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }
}
