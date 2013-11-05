package jpa.mapping.collection.map;

import static org.junit.Assert.*;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import jpa.mapping.basic.PersistenceTest;

import org.junit.Test;

public class EmployeeWithMapOfPhonesTest extends PersistenceTest {

    @Test
    public void shouldCreateEmployee() {
        entityManager.getTransaction().begin();
        EmployeeWithMapOfPhones employee = new EmployeeWithMapOfPhones("emp 1", 0L);
        employee.addPhoneNumber("HOME", "123");
        employee.addPhoneNumber("WORK", "456");
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        // find the employee
        EntityManager entityManager2 = entityManagerFactory.createEntityManager();
        EmployeeWithMapOfPhones newEmployee = entityManager2.find(EmployeeWithMapOfPhones.class, employee.getId());
        assertNotNull(newEmployee);

        for (String type : newEmployee.getPhoneNumbers().keySet()) {
            System.out.println(type + "\t" + newEmployee.getPhoneNumbers().get(type));
        }

        // another employee
        entityManager.getTransaction().begin();
        employee = new EmployeeWithMapOfPhones("emp 2", 0L);
        employee.addPhoneNumber("HOME", "123");
        employee.addPhoneNumber("WORK", "789");
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        // find the new employee
        newEmployee = entityManager2.find(EmployeeWithMapOfPhones.class, employee.getId());
        assertNotNull(newEmployee);

        for (String type : newEmployee.getPhoneNumbers().keySet()) {
            System.out.println(type + "\t" + newEmployee.getPhoneNumbers().get(type));
        }

    }

}
