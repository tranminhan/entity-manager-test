package jpa.mapping.basic.id.auto;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import jpa.mapping.basic.PersistenceTest;

import org.junit.Test;

public class EmployeeWithIdFromTableTest extends PersistenceTest {

    @Test
    public void shouldCreateEmployeeWithId() {
        BigDecimal maxId = (BigDecimal) entityManager.createNativeQuery("select ID_VALUE from ID_TABLE where ID_NAME='Emp_Gen'").getSingleResult();
        System.out.println("maxId : " + maxId);

        entityManager.getTransaction().begin();
        EmployeeWithIdFromTable employee = new EmployeeWithIdFromTable();
        employee.setName("employee 2");
        employee.setSalary(200L);
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        System.out.println(employee.getId());
        assertNotNull(employee.getId());

        maxId = (BigDecimal) entityManager.createNativeQuery("select ID_VALUE from ID_TABLE where ID_NAME='Emp_Gen'").getSingleResult();
        System.out.println("maxId : " + maxId);
    }

}
