package jpa.mapping.basic.id.auto;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;

import jpa.mapping.basic.PersistenceTest;

import org.junit.Test;

public class EmployeeWithDateIdTest extends PersistenceTest {

    @Test
    public void shouldCreateEmployeeWithId() {
        entityManager.getTransaction().begin();
        EmployeeWithDateId employee = new EmployeeWithDateId();
        employee.setName("employee 2");
        employee.setSalary(200L);
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        System.out.println(sdf.format(employee.getId()));
        assertNotNull(employee.getId());
    }

    @Test
    public void shouldCreateTwoEmployees() {
        entityManager.getTransaction().begin();
        EmployeeWithDateId employee = new EmployeeWithDateId();
        employee.setName("employee 2");
        employee.setSalary(200L);
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        System.out.println(sdf.format(employee.getId()));        
        assertNotNull(employee.getId());

        entityManager.getTransaction().begin();
        employee = new EmployeeWithDateId();
        employee.setName("employee 3");
        employee.setSalary(200L);
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        System.out.println(sdf.format(employee.getId()));
        assertNotNull(employee.getId());
    }
}
