package jpa.mapping.key.embeddedId;

import javax.persistence.Embeddable;

@Embeddable
public class EmployeeId {
    String country;
    int    id;

    public EmployeeId(String country, int id) {
        super();
        this.country = country;
        this.id = id;
    }

    public EmployeeId() {
        super();
    }

    public String getCountry() {
        return country;
    }

    public int getId() {
        return id;
    }

}
