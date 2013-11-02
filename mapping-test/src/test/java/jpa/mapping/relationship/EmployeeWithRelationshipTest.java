package jpa.mapping.relationship;

import static org.junit.Assert.*;
import jpa.mapping.basic.PersistenceTest;
import jpa.mapping.basic.id.auto.EmployeeWithStringId;

import org.junit.Test;

public class EmployeeWithRelationshipTest extends PersistenceTest {

    @Test
    public void shouldCreateEmployee() {
        entityManager.getTransaction().begin();
        EmployeeWithRelationship employee = new EmployeeWithRelationship();
        employee.setName("employee 2");
        employee.setSalary(200L);

        Department department = new Department();
        department.setName("IT");
        employee.setDepartment(department);

        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        System.out.println(employee.getId());
        assertNotNull(employee.getId());

        Department department2 = entityManager.createQuery("select d from Department d", Department.class).getSingleResult();
        assertNotNull(department2);
        assertEquals("IT", department2.getName());
        assertSame(department, department2);
    }

}
