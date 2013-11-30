package jpa.mapping.key.idclass;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(EmployeeId.class)
public class EmployeeWithIdClass {

    public EmployeeWithIdClass(String country, int id, String name) {
        super();
        this.country = country;
        this.id = id;
        this.name = name;
    }

    public EmployeeWithIdClass() {
        super();
    }

    @Id
    String country;
    @Id
    int    id;

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public int getId() {
        return id;
    }
    
    
}
