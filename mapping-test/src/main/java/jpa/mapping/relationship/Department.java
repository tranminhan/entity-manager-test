package jpa.mapping.relationship;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {

    @Id
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
