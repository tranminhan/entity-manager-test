package jpa.inheritance.pertable;

import javax.persistence.Entity;

@Entity
public class PTFullTimeEmployee extends PTCompanyEmployee {
    Long salary;
    Long pension;

    public PTFullTimeEmployee() {
        super();
    }

    public PTFullTimeEmployee(String name, Long salary, Long pension) {
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
