package jpa.lifecycle;

import static org.junit.Assert.*;

import javax.ejb.EJB;

import jpa.em.app.ContainerAndPersistentTest;
import jpa.em.app.Employee;
import jpa.em.app.EmployeeService;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest extends ContainerAndPersistentTest {
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
    }
}
