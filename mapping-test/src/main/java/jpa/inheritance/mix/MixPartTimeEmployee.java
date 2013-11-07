package jpa.inheritance.mix;

import javax.persistence.Entity;

@Entity
public class MixPartTimeEmployee extends MixCompanyEmployee {
    float hourlyRate;

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public MixPartTimeEmployee() {
        super();
    }

    public MixPartTimeEmployee(String name, float hourlyRate) {
        super(name);
        this.hourlyRate = hourlyRate;
    }
}
