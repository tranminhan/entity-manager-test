package jpa.mapping.key.derived;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DepartmentWithDependent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int    id;

    String name;

    public DepartmentWithDependent() {
        super();
    }

    public DepartmentWithDependent(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

}
