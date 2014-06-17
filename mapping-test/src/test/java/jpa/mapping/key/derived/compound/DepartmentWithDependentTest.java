package jpa.mapping.key.derived.compound;

import static org.junit.Assert.*;
import jpa.mapping.basic.PersistenceTest;
import jpa.mapping.key.idclass.EmployeeId;
import jpa.mapping.key.idclass.EmployeeWithIdClass;

import org.junit.Test;

public class DepartmentWithDependentTest extends PersistenceTest {

    @Test
    public void test() {
        entityManager.getTransaction().begin();
        DepartmentWithDependent department = new DepartmentWithDependent("VN", 1, "HR");
        entityManager.persist(department);
        entityManager.getTransaction().commit();

        DepartmentWithDependent department2 = entityManager.find(DepartmentWithDependent.class, new DepartmentId("VN", 1));
        assertNotNull(department2);
    }


}
