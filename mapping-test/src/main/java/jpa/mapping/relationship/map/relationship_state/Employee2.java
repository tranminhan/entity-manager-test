package jpa.mapping.relationship.map.relationship_state;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Employee2 {
    @Id
    @TableGenerator(name = "Emp_Gen",
            table = "ID_TABLE",
            pkColumnName = "ID_NAME",
            valueColumnName = "ID_VALUE",
            allocationSize = 1)
    @GeneratedValue(generator = "Emp_Gen")
    Integer             id;
    String              name;

    @ElementCollection
    @CollectionTable(name = "EMP_PROJECTS")
    @Column(name = "STARTDATE")
    @Temporal(TemporalType.DATE)
    Map<Project2, Date> currentProjects = new HashMap<Project2, Date>();

    public void addProject(Project2 project, Date startDate) {
        currentProjects.put(project, startDate);
    }

    public Employee2() {
        super();
    }

    public Employee2(String name) {
        super();
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
