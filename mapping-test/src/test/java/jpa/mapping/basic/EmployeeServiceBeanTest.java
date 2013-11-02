package jpa.mapping.basic;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmployeeServiceBeanTest {
    EntityManager        entityManager;
    EmployeeService      employeeService;
    EntityManagerFactory entityManagerFactory;

    @Before
    public void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("mapping.basic");
        entityManager = entityManagerFactory.createEntityManager();

        employeeService = new EmployeeServiceBean(entityManager);
    }

    @After
    public void teardown() {
        entityManager.close();
    }

    @Test
    public void shouldCreateEmployee() {
        EmployeeBasic employee1 = employeeService.createEmployee(1, "employee 1", 100L);
        assertNotNull(employee1);

        EntityManager entityManager2 = entityManagerFactory.createEntityManager();
        Long count = entityManager2.createQuery("select count(e) from EmployeeBasic e", Long.class).getSingleResult();

        assertEquals((Long)1L, count);
    }
}
