package jpa.mapping.relationship;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import jpa.mapping.basic.PersistenceTest;
import jpa.mapping.basic.id.auto.EmployeeWithStringId;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;

public class EmployeeWithRelationshipTest extends PersistenceTest {

    @Test
    public void shouldCreateEmployee() {
        entityManager.getTransaction().begin();
        EmployeeWithRelationship employee = new EmployeeWithRelationship();
        employee.setName("employee 2");
        employee.setSalary(200L);

        Department department = new Department();
        department.setName("IT");
        employee.setDepartment(department);

        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        System.out.println(employee.getId());
        assertNotNull(employee.getId());

        Department department2 = entityManager.createQuery("select d from Department d", Department.class).getSingleResult();
        assertNotNull(department2);
        assertEquals("IT", department2.getName());
        assertSame(department, department2);

        String fkId = (String) entityManager.createNativeQuery("select DEPT_ID from EmployeeWithRelationship").getSingleResult();
        System.out.println("foreign key: " + fkId);
    }

    @Test
    public void shouldCreateEmployeeWithParkingSpace() {
        entityManager.getTransaction().begin();
        EmployeeWithRelationship employee = new EmployeeWithRelationship();
        employee.setName("employee 2");
        employee.setSalary(200L);

        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setLocation("3E");
        employee.setParkingSpace(parkingSpace);
        parkingSpace.setEmployee(employee);

        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        assertNotNull(parkingSpace.getId());
        assertNotNull(parkingSpace.getEmployee());

        EntityManager entityManager2 = entityManagerFactory.createEntityManager();

        ParkingSpace parkingSpace2 = entityManager2.find(ParkingSpace.class, parkingSpace.getId());

        System.out.println(ReflectionToStringBuilder.toString(employee));
        System.out.println(ReflectionToStringBuilder.toString(parkingSpace2.getEmployee()));

        assertEquals(parkingSpace, parkingSpace2);
        assertNotNull(parkingSpace2.getEmployee());
        assertEquals(employee, parkingSpace2.getEmployee());
    }

    @Test
    public void shouldCreateMultipleEmployeesForDepartment() {
        entityManager.getTransaction().begin();
        EmployeeWithRelationship employee1 = new EmployeeWithRelationship("emp 1", 100L);
        EmployeeWithRelationship employee2 = new EmployeeWithRelationship("emp 2", 200L);

        Department department = new Department("HR");
        department.addEmployee(employee1);
        department.addEmployee(employee2);

        entityManager.persist(employee1);
        entityManager.persist(employee2);

        entityManager.getTransaction().commit();

        EntityManager entityManager2 = entityManagerFactory.createEntityManager();
        Department department2 = entityManager2.find(Department.class, department.getName());
        assertNotNull(department2);
        assertEquals(department, department2);
        assertEquals(2, department2.getEmployees().size());
    }
}
