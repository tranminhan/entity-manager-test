package jpa.mapping.relationship.map.relationship_state;

import static org.junit.Assert.*;

import java.util.Date;

import javax.persistence.EntityManager;

import jpa.mapping.basic.PersistenceTest;
import jpa.mapping.relationship.map.attribute.DepartmentWithMapKeyedByAttribute;
import jpa.mapping.relationship.map.attribute.EmployeeWithKeyAttribute;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;

public class Employee2Test extends PersistenceTest {

    @Test
    public void shouldCreateDepartment() {
        entityManager.getTransaction().begin();
        Project2 projectML = new Project2("MarketLive");
        entityManager.persist(projectML);

        Project2 projectHMS = new Project2("HMS");
        entityManager.persist(projectHMS);
        
        
        Employee2 employee2 = new Employee2("An");
        employee2.addProject(projectML, new Date());
        employee2.addProject(projectHMS, new Date());
        entityManager.persist(employee2);
        entityManager.getTransaction().commit();

    }
}
