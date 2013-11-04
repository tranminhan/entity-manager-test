package jpa.mapping.relationship.ordering;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import jpa.mapping.basic.PersistenceTest;

import org.junit.Test;

public class DepartmentWithListOfEntitiesTest extends PersistenceTest {

    @Test
    public void shouldCreateDepartment() {
        entityManager.getTransaction().begin();

        DepartmentWithListOfEntities deparment = new DepartmentWithListOfEntities("COMP");
        deparment.addEmployee("a_emp_1");
        deparment.addEmployee("z_emp_2");
        deparment.addEmployee("h_emp_3");

        entityManager.persist(deparment);
        entityManager.getTransaction().commit();

        EntityManager entityManager2 = entityManagerFactory.createEntityManager();
        DepartmentWithListOfEntities department2 = entityManager2.find(DepartmentWithListOfEntities.class, deparment.getName());
        assertNotNull(department2);
        assertEquals(3, department2.getEmployees().size());
        for (EmployeeInOrder emp : department2.getEmployees()) {
            System.out.println(emp.getName());
        }

    }

}
