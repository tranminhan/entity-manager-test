package jpa.em.app;

import static org.junit.Assert.*;

import javax.ejb.EJB;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Before;
import org.junit.Test;

public class EmployeeServiceTestAddAddress extends ContainerAndPersistentTest {

    @Before
    public void setup() {
        super.setup();
    }

    @EJB
    EmployeeService employeeService;

    @Test
    public void shouldAddAddressToEmployee() {
        Employee employee = employeeService.newEmployee("Peter", new Address("617 B Second Street", "CA", "Petaluma", "94952"));
        assertNotNull(employee);

        Employee employee2 = employeeService.findEmployee(employee.getId());
        System.out.println(ReflectionToStringBuilder.toString(employee2));
        System.out.println(ReflectionToStringBuilder.toString(employee2.getAddress()));
        assertNotNull(employee2);
        assertNotNull(employee2.getAddress());
    }

    @Test
    public void shouldAddAddressToEmployeeAfterPersist() {
        Employee employee = employeeService.newEmployeeAfterPersist("Peter", new Address("617 B Second Street", "CA", "Petaluma", "94952"));
        assertNotNull(employee);

        Employee employee2 = employeeService.findEmployee(employee.getId());
        System.out.println(ReflectionToStringBuilder.toString(employee2));
        System.out.println(ReflectionToStringBuilder.toString(employee2.getAddress()));
        assertNotNull(employee2);
        assertNotNull(employee2.getAddress());
    }
}
