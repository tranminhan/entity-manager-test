package jpa.mapping.relationship;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

@Entity
public class EmployeeWithRelationship {
    @Id
    @TableGenerator(name = "Emp_Gen",
            table = "ID_TABLE",
            pkColumnName = "ID_NAME",
            valueColumnName = "ID_VALUE",
            allocationSize = 1)
    @GeneratedValue(generator = "Emp_Gen")
    Integer      id;
    String       name;
    Long         salary;

    @OneToOne(cascade = { CascadeType.PERSIST })
    ParkingSpace parkingSpace;

    @ManyToOne(cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "DEPT_ID")
    Department   department;

    public EmployeeWithRelationship() {

    }

    public EmployeeWithRelationship(String name, Long salary) {
        super();
        this.name = name;
        this.salary = salary;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((department == null) ? 0 : department.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((parkingSpace == null) ? 0 : parkingSpace.hashCode());
        result = prime * result + ((salary == null) ? 0 : salary.hashCode());
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
        EmployeeWithRelationship other = (EmployeeWithRelationship) obj;
        if (department == null) {
            if (other.department != null)
                return false;
        }
        else if (!department.equals(other.department))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        if (parkingSpace == null) {
            if (other.parkingSpace != null)
                return false;
        }
        else if (!parkingSpace.equals(other.parkingSpace))
            return false;
        if (salary == null) {
            if (other.salary != null)
                return false;
        }
        else if (!salary.equals(other.salary))
            return false;
        return true;
    }
}
