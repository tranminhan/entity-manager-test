package jpa.mapping.collection.map;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import jpa.mapping.basic.PersistenceTest;

import org.junit.Test;

public class EmployeeWithMapEnumeratedKeyTest extends PersistenceTest {

    @Test
    public void shouldCreateEmployee() {
        entityManager.getTransaction().begin();
        EmployeeWithMapEnumeratedKey employee = new EmployeeWithMapEnumeratedKey("emp 1", 0L);
        employee.addPhoneNumber(PhoneType.HOME, "123");
        employee.addPhoneNumber(PhoneType.WORK, "456");
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        // find the employee
        EntityManager entityManager2 = entityManagerFactory.createEntityManager();
        EmployeeWithMapEnumeratedKey newEmployee = entityManager2.find(EmployeeWithMapEnumeratedKey.class, employee.getId());
        assertNotNull(newEmployee);

        for (PhoneType type : newEmployee.getPhoneNumbers().keySet()) {
            System.out.println(type + "\t" + newEmployee.getPhoneNumbers().get(type));
        }

        // another employee
        entityManager.getTransaction().begin();
        employee = new EmployeeWithMapEnumeratedKey("emp 2", 0L);
        employee.addPhoneNumber(PhoneType.HOME, "123");
        employee.addPhoneNumber(PhoneType.WORK, "798");
        employee.addPhoneNumber(PhoneType.MOBILE, "234");
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        // find the new employee
        newEmployee = entityManager2.find(EmployeeWithMapEnumeratedKey.class, employee.getId());
        assertNotNull(newEmployee);

        for (PhoneType type : newEmployee.getPhoneNumbers().keySet()) {
            System.out.println(type + "\t" + newEmployee.getPhoneNumbers().get(type));
        }

    }

}
