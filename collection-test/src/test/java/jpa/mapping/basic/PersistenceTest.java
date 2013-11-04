package jpa.mapping.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;

public class PersistenceTest {
    protected EntityManager        entityManager;
    protected EntityManagerFactory entityManagerFactory;

    @Before
    public void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("mapping.basic");
        entityManager = entityManagerFactory.createEntityManager();

    }

    @After
    public void teardown() {
        entityManager.close();
    }

}
