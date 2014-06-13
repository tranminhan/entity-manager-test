package jpa.mapping.key.derived.compound;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@IdClass(ProjectId.class)
public class ProjectAsDependent {
    @Id
    String                  name;

    @Id
    @ManyToOne
    DepartmentWithDependent department;

    public String getName() {
        return name;
    }

    public DepartmentWithDependent getDepartment() {
        return department;
    }

    public ProjectAsDependent(String name, DepartmentWithDependent department) {
        super();
        this.name = name;
        this.department = department;
    }

    public ProjectAsDependent() {
        super();
    }

}
