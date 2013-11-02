package jpa.mapping.basic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersistenceTest {
    protected EntityManager        entityManager;
    protected EmployeeService      employeeService;
    protected EntityManagerFactory entityManagerFactory;

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

}
