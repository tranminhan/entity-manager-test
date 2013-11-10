package jpa.mapping.embedded;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class EmbeddedPhone {

    @Id
    String number;
    
//    @ManyToMany(mappedBy="contactInfo.phones")
//    List<EmployeeWithComplexEmbedded> employees;

    public EmbeddedPhone(String number) {
        super();
        this.number = number;
    }

    public EmbeddedPhone() {
        super();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
