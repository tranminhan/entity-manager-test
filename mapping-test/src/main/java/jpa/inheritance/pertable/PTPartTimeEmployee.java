package jpa.inheritance.pertable;

import javax.persistence.Entity;

@Entity
public class PTPartTimeEmployee extends PTCompanyEmployee {
    float hourlyRate;

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public PTPartTimeEmployee() {
        super();
    }

    public PTPartTimeEmployee(String name, float hourlyRate) {
        super(name);
        this.hourlyRate = hourlyRate;
    }
}
