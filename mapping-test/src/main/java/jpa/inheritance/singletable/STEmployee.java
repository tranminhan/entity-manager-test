package jpa.inheritance.singletable;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "EMP_TYPE")
public abstract class STEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String  name;
    @Temporal(TemporalType.DATE)
    Date    startDate;

    public STEmployee(String name) {
        super();
        this.name = name;
    }

    public STEmployee() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getId() {
        return id;
    }

}
