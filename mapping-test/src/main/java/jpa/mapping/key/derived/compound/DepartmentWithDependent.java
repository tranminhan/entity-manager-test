package jpa.mapping.key.derived.compound;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(DepartmentId.class)
public class DepartmentWithDependent {

    @Id
    String country;
    @Id
    int    number;
    String name;

    public DepartmentWithDependent() {
        super();
    }

    public DepartmentWithDependent(String country, int number, String name) {
        super();
        this.country = country;
        this.number = number;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public int getNumber() {
        return number;
    }

}
