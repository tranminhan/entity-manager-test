package jpa.inheritance.mix;

import javax.persistence.Entity;

@Entity
public class MixContractEmployee extends MixEmployee {
    Integer dailyRate;
    Integer term;

    public MixContractEmployee() {
    }

    public MixContractEmployee(String name, Integer dailyRate) {
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
