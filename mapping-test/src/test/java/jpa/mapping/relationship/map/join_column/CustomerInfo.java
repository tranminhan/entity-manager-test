package jpa.mapping.relationship.map.join_column;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class CustomerInfo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;
    
    String name;
    
    @OneToMany
    @JoinColumn(name="CUST_INFO_ID")
    List<Address3> addresses;

    public CustomerInfo(String name) {
        super();
        this.name = name;
    }

    public CustomerInfo() {
        super();
    }
}
