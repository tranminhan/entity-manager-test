package jpa.em.app;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class EmployeeDebugListener {
    @PrePersist
    public void prePersist(Object employee) {
        System.out.println("EmployeeDebugListener.PrePersist: " + ReflectionToStringBuilder.toString(employee));
    }

    @PostPersist
    public void postPersist(Employee employee) {
        System.out.println("EmployeeDebugListener.PostPersist: " + ReflectionToStringBuilder.toString(employee));
    }

    @PreUpdate
    public void preUpdate(Employee employee) {
        System.out.println("EmployeeDebugListener.PreUpdate: " + ReflectionToStringBuilder.toString(employee));
    }

    @PostUpdate
    public void postUpdate(Object employee) {
        System.out.println("EmployeeDebugListener.PostUpdate: " + ReflectionToStringBuilder.toString(employee));
    }
}
