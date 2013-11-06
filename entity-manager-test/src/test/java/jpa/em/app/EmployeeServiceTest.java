package jpa.em.app;

import static org.junit.Assert.*;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class EmployeeServiceTest extends ContainerAndPersistentTest {

    @Before
    public void setup() {
        super.setup();
    }

    @EJB
    EmployeeService employeeService;

    @Test
    public void shouldCreateEmployee() {
        Employee employee = employeeService.newEmployee("Peter");
        assertNotNull(employee);
        System.out.println(ReflectionToStringBuilder.toString(employee));

        Employee employee2 = employeeService.findEmployee(employee.getId());
        System.out.println(ReflectionToStringBuilder.toString(employee2));
        assertNotNull(employee2);
        
        Employee employee3 = em.find(Employee.class, employee.getId());
        System.out.println(ReflectionToStringBuilder.toString(employee3));
        assertNotNull(employee2);        
    }

    @Ignore
    @Test
    public void shouldEditExistingEmployee() {
        em.getTransaction().begin();
        Employee employee = new Employee("Peter");
        em.persist(employee);
        em.getTransaction().commit();

        Employee newEmployee = em.find(Employee.class, employee.getId());
        assertNotNull(newEmployee);
        System.out.println(ReflectionToStringBuilder.toString(newEmployee));

        Employee employee2 = employeeService.changeName(employee.getId(), "Hand");
        System.out.println(ReflectionToStringBuilder.toString(employee2));
    }
}
