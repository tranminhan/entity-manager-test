package jpa.inheritance.mix;

import javax.persistence.Entity;

@Entity
public class MixFullTimeEmployee extends MixCompanyEmployee {
    Long salary;
    Long pension;

    public MixFullTimeEmployee() {
        super();
    }

    public MixFullTimeEmployee(String name, Long salary, Long pension) {
        super(name);
        this.salary = salary;
        this.pension = pension;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Long getPension() {
        return pension;
    }

    public void setPension(Long pension) {
        this.pension = pension;
    }
}
