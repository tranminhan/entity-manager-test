package jpa.mapping.relationship.jointable;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import jpa.mapping.basic.PersistenceTest;
import jpa.mapping.relationship.EmployeeWithRelationship;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;

public class EmployeeWithMultipleDepartmentsTest extends PersistenceTest {

    @Test
    public void shouldCreateEmployee() {
        entityManager.getTransaction().begin();

        EmployeeWithMultipleDepartments employee = new EmployeeWithMultipleDepartments("emp 1", 100L);
        DepartmentWithMultipleEmployees department = new DepartmentWithMultipleEmployees("ACCOUNTING");
        department.addEmployee(employee);

        entityManager.persist(employee);

        employee = new EmployeeWithMultipleDepartments("emp 2", 200L);
        department.addEmployee(employee);

        entityManager.persist(employee);
        entityManager.persist(department);

        entityManager.getTransaction().commit();

        // checking in another context
        EntityManager entityManager2 = entityManagerFactory.createEntityManager();

        EmployeeWithMultipleDepartments employee2 = entityManager2.find(EmployeeWithMultipleDepartments.class, employee.getId());
        assertNotNull(employee2);
        assertEquals(1, employee2.getDepartments().size());

        DepartmentWithMultipleEmployees department2 = entityManager2.find(DepartmentWithMultipleEmployees.class, department.getName());
        assertNotNull(department2);
        assertEquals(2, department2.getEmployees().size());

        entityManager2.close();
    }

    @Test
    public void shouldCreateEmployeeWithPhones() {
        entityManager.getTransaction().begin();

        EmployeeWithMultipleDepartments employee = new EmployeeWithMultipleDepartments("emp 1", 100L);
        employee.addPhone(new Phone("123"));
        employee.addPhone(new Phone("245"));
        entityManager.persist(employee);

        entityManager.getTransaction().commit();

        // checking in another context
        EntityManager entityManager2 = entityManagerFactory.createEntityManager();
        System.out.println("entityManager2");
        EmployeeWithMultipleDepartments employee2 = entityManager2.find(EmployeeWithMultipleDepartments.class, employee.getId());
        assertNotNull(employee2);
        assertEquals(2, employee2.getPhones().size());

        System.out.println("before loading phones");
        for (Phone phone : employee2.getPhones()) {
            System.out.println(ReflectionToStringBuilder.toString(phone));
        }

        entityManager2.close();
    }
}
