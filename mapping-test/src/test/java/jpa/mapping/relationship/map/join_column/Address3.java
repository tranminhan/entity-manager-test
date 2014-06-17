package jpa.mapping.relationship.map.join_column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Address3 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int    id;

    String street;
    String zip;

    public Address3(String street, String zip) {
        super();
        this.street = street;
        this.zip = zip;
    }

    public Address3() {
        super();
    }

}
