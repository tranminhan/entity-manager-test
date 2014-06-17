package jpa.mapping.key.derived.compound;

import java.io.Serializable;

public class DepartmentId implements Serializable {

    private static final long serialVersionUID = 1L;
    
    String                    country;
    int                       number;

    public String getCountry() {
        return country;
    }

    public int getNumber() {
        return number;
    }

    public DepartmentId() {
        super();
    }

    public DepartmentId(String country, int number) {
        super();
        this.country = country;
        this.number = number;
    }

}
