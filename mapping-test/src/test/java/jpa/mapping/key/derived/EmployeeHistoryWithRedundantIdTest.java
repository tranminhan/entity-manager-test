package jpa.mapping.key.derived;

import static org.junit.Assert.*;
import jpa.mapping.basic.PersistenceTest;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;

public class EmployeeHistoryWithRedundantIdTest extends PersistenceTest {

    @Test
    public void test() {
        entityManager.getTransaction().begin();
        EmployeeAsOwner employee = new EmployeeAsOwner("Adam");
        EmployeeHistoryWithRedundantId employeeHistory = new EmployeeHistoryWithRedundantId(employee);
        employeeHistory.setDescription("some thing ");
        entityManager.persist(employee);
        entityManager.persist(employeeHistory);
        entityManager.getTransaction().commit();

        EmployeeAsOwner employeeAsOwner = entityManager.find(EmployeeAsOwner.class, employee.getId());
        assertNotNull(employeeAsOwner);
        System.out.println(ReflectionToStringBuilder.toString(employeeAsOwner));

        EmployeeHistoryWithRedundantId employeeHistory2 = entityManager.find(EmployeeHistoryWithRedundantId.class, employee.getId());
        assertNotNull(employeeHistory2);
        System.out.println(ReflectionToStringBuilder.toString(employeeHistory2));

    }

    @Test
    public void shouldNotAllowLinkViaIdAttributeOnlyBecauseAttributeIdIsReadOnly() {
        entityManager.getTransaction().begin();
        EmployeeAsOwner employee = new EmployeeAsOwner("Adam");
        entityManager.persist(employee);

        EmployeeHistoryWithRedundantId employeeHistory = new EmployeeHistoryWithRedundantId();
        employeeHistory.setEmpId(employee.getId());
        employeeHistory.setDescription("some thing ");
        entityManager.persist(employeeHistory);
        entityManager.getTransaction().commit();

        EmployeeAsOwner employeeAsOwner = entityManager.find(EmployeeAsOwner.class, employee.getId());
        assertNotNull(employeeAsOwner);
        System.out.println(ReflectionToStringBuilder.toString(employeeAsOwner));

        EmployeeHistoryWithRedundantId employeeHistory2 = entityManager.find(EmployeeHistoryWithRedundantId.class, employee.getId());
        assertNotNull(employeeHistory2);
        System.out.println(ReflectionToStringBuilder.toString(employeeHistory2));

    }

}
