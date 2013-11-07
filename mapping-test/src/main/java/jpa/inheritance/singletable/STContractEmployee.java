package jpa.inheritance.singletable;

import javax.persistence.Entity;

@Entity
public class STContractEmployee extends STEmployee {
    Integer dailyRate;
    Integer term;

    public STContractEmployee() {
    }

    public STContractEmployee(String name, Integer dailyRate) {
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
