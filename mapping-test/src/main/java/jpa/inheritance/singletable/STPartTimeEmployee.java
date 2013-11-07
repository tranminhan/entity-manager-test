package jpa.inheritance.singletable;

import javax.persistence.Entity;

@Entity
public class STPartTimeEmployee extends STCompanyEmployee {
    float hourlyRate;

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public STPartTimeEmployee() {
        super();
    }

    public STPartTimeEmployee(String name, float hourlyRate) {
        super(name);
        this.hourlyRate = hourlyRate;
    }
}
