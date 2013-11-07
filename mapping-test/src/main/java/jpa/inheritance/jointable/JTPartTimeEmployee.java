package jpa.inheritance.jointable;

import javax.persistence.Entity;

@Entity
public class JTPartTimeEmployee extends JTCompanyEmployee {
    float hourlyRate;

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public JTPartTimeEmployee() {
        super();
    }

    public JTPartTimeEmployee(String name, float hourlyRate) {
        super(name);
        this.hourlyRate = hourlyRate;
    }
}
