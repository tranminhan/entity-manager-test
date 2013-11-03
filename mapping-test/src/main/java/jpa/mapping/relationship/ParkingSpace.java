package jpa.mapping.relationship;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ParkingSpace {

    public EmployeeWithRelationship getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeWithRelationship employee) {
        this.employee = employee;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer                  id;
    String                   location;

    @OneToOne(mappedBy = "parkingSpace")
    EmployeeWithRelationship employee;

    public Integer getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
       result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ParkingSpace other = (ParkingSpace) obj;

        if (id == null) {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        if (location == null) {
            if (other.location != null)
                return false;
        }
        else if (!location.equals(other.location))
            return false;
        return true;
    }

}
