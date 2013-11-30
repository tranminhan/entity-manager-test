package jpa.mapping.key.idclass;

import java.io.Serializable;

public class EmployeeId implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    String country;
    int    id;

    public EmployeeId(String country, int id) {
        super();
        this.country = country;
        this.id = id;
    }

    public EmployeeId() {
        super();
    }

    public String getCountry() {
        return country;
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + id;
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
        EmployeeId other = (EmployeeId) obj;
        if (country == null) {
            if (other.country != null)
                return false;
        }
        else if (!country.equals(other.country))
            return false;
        if (id != other.id)
            return false;
        return true;
    }
}
