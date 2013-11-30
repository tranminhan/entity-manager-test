package jpa.mapping.key.embeddedId;

import static org.junit.Assert.*;
import jpa.mapping.basic.PersistenceTest;


import org.junit.Test;

public class EmployeeWithEmbeddedIdTest extends PersistenceTest {

    @Test
    public void test() {
        entityManager.getTransaction().begin();
        EmployeeWithEmbeddedId employee = new EmployeeWithEmbeddedId(new EmployeeId("VN", 1), "An");
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        EmployeeWithEmbeddedId employeeWithIdClass = entityManager.find(EmployeeWithEmbeddedId.class, new EmployeeId("VN", 1));
        assertNotNull(employeeWithIdClass);
    }

}
