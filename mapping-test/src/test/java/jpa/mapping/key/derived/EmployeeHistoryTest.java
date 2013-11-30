package jpa.mapping.key.derived;

import static org.junit.Assert.*;
import jpa.mapping.basic.PersistenceTest;
import jpa.mapping.key.embeddedId.EmployeeId;
import jpa.mapping.key.embeddedId.EmployeeWithEmbeddedId;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;

public class EmployeeHistoryTest extends PersistenceTest {

    @Test
    public void test() {
        entityManager.getTransaction().begin();
        EmployeeAsOwner employee = new EmployeeAsOwner("Adam");
        EmployeeHistory employeeHistory = new EmployeeHistory(employee);
        employeeHistory.setDescription("some thing ");
        entityManager.persist(employee);
        entityManager.persist(employeeHistory);
        entityManager.getTransaction().commit();

        EmployeeAsOwner employeeAsOwner = entityManager.find(EmployeeAsOwner.class, employee.getId());
        assertNotNull(employeeAsOwner);
        System.out.println(ReflectionToStringBuilder.toString(employeeAsOwner));

        EmployeeHistory employeeHistory2 = entityManager.find(EmployeeHistory.class, employee.getId());
        assertNotNull(employeeHistory2);
        System.out.println(ReflectionToStringBuilder.toString(employeeHistory2));

    }

}
