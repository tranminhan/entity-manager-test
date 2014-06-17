package jpa.mapping.key.derived.compound;

import java.io.Serializable;

public class ProjectId implements Serializable {

    private static final long serialVersionUID = 6970570621262643686L;
    String                    name;
    DepartmentId              departmentId;

    public ProjectId() {
        super();
    }

    public ProjectId(String name, DepartmentId departmentId) {
        super();
        this.name = name;
        this.departmentId = departmentId;
    }

}
