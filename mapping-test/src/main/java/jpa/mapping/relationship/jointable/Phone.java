package jpa.mapping.relationship.jointable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Phone {

    @Id
    String number;

    public Phone() {

    }

    public Phone(String number) {
        super();
        this.number = number;
    }

}
