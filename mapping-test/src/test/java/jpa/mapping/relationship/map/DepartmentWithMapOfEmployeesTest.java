package jpa.mapping.relationship.map;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import jpa.mapping.basic.PersistenceTest;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;

public class DepartmentWithMapOfEmployeesTest extends PersistenceTest {

    @Test
    public void shouldCreateDepartment() {
        entityManager.getTransaction().begin();
        DepartmentWithMapOfEmployees department = new DepartmentWithMapOfEmployees("IT");
        department.addEmployee("A1", new EmployeeInCubicle("emp 1"));
        department.addEmployee("B1", new EmployeeInCubicle("emp 2"));
        department.addEmployee("C3", new EmployeeInCubicle("emp 3"));
        department.addEmployee("D5", new EmployeeInCubicle("emp 4"));
        entityManager.persist(department);
        entityManager.getTransaction().commit();

        EntityManager entityManager2 = entityManagerFactory.createEntityManager();
        DepartmentWithMapOfEmployees newDepartment = entityManager2.find(DepartmentWithMapOfEmployees.class, department.getName());
        assertNotNull(newDepartment);
        for (String cube : newDepartment.getEmployees().keySet()) {
            System.out.println(cube + "\t" + ReflectionToStringBuilder.toString(newDepartment.getEmployees().get(cube)));
        }
    }

}
