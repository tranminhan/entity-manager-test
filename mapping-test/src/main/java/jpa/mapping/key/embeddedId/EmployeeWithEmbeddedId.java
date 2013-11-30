package jpa.mapping.key.embeddedId;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class EmployeeWithEmbeddedId {

    @EmbeddedId
    EmployeeId id;

    String     name;

    public EmployeeWithEmbeddedId() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeId getId() {
        return id;
    }

    public EmployeeWithEmbeddedId(EmployeeId id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
