package jpa.mapping.relationship.map.relationship_state;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int    id;

    String name;

    public Project2() {
        super();
    }

    public Project2(String name) {
        super();
        this.name = name;
    }
   

}
