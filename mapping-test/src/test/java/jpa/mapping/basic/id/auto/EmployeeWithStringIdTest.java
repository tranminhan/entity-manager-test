package jpa.mapping.basic.id.auto;

import static org.junit.Assert.*;
import jpa.mapping.basic.PersistenceTest;

import org.junit.Test;

public class EmployeeWithStringIdTest extends PersistenceTest {

    @Test
    public void shouldCreateEmployeeWithId() {
        entityManager.getTransaction().begin();
        EmployeeWithStringId employee = new EmployeeWithStringId();
        employee.setName("employee 2");
        employee.setSalary(200L);
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        System.out.println(employee.getId());
        assertNotNull(employee.getId());
    }

}
