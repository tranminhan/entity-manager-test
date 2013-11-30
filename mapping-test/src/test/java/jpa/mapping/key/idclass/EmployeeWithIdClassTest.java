package jpa.mapping.key.idclass;

import static org.junit.Assert.*;
import jpa.mapping.basic.PersistenceTest;
import jpa.mapping.embedded.EmployeeWithComplexEmbedded;
import jpa.mapping.key.idclass.EmployeeId;
import jpa.mapping.key.idclass.EmployeeWithIdClass;

import org.junit.Test;

public class EmployeeWithIdClassTest extends PersistenceTest {

    @Test
    public void test() {
        entityManager.getTransaction().begin();
        EmployeeWithIdClass employee = new EmployeeWithIdClass("VN", 1, "An");
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        
        EmployeeWithIdClass employeeWithIdClass = entityManager.find(EmployeeWithIdClass.class, new EmployeeId("VN", 1));
        assertNotNull(employeeWithIdClass);
    }

}
