package jpa.mapping.relationship.map.attribute;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;

import jpa.mapping.basic.PersistenceTest;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;

public class DepartmentWithMapKeyedByAttributeTest extends PersistenceTest {

    @Test
    public void shouldCreateDepartment() {
        entityManager.getTransaction().begin();
        DepartmentWithMapKeyedByAttribute department = new DepartmentWithMapKeyedByAttribute("IT");

        EmployeeWithKeyAttribute employee = new EmployeeWithKeyAttribute("emp 1");
        entityManager.persist(employee);
        department.addEmployee(employee);

        employee = new EmployeeWithKeyAttribute("emp 2");
        entityManager.persist(employee);
        department.addEmployee(employee);

        entityManager.persist(department);
        entityManager.getTransaction().commit();

        EntityManager entityManager2 = entityManagerFactory.createEntityManager();
        DepartmentWithMapKeyedByAttribute newDepartment = entityManager2.find(DepartmentWithMapKeyedByAttribute.class, department.getName());
        assertNotNull(newDepartment);
        for (Integer id : newDepartment.getEmployees().keySet()) {
            System.out.println(id + "\t" + ReflectionToStringBuilder.toString(newDepartment.getEmployees().get(id)));
        }
    }
}
