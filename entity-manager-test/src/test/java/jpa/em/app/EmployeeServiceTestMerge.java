package jpa.em.app;

import static org.junit.Assert.*;

import javax.ejb.EJB;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.junit.Before;
import org.junit.Test;

public class EmployeeServiceTestMerge extends ContainerAndPersistentTest {

    @Before
    public void setup() {
        super.setup();
    }

    @EJB
    EmployeeService employeeService;

    @Test
    public void shouldMergeChangeToEntity() throws NotSupportedException, SystemException, IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException,
            RollbackException {
        // create an entity
        Employee employee = employeeService.newEmployee("Peter");
        assertNotNull(employee);

        // now it is detached
        employee.setName("Peter 2nd");

        // find the employee from db
        tx.begin();
        Employee employee2 = em.find(Employee.class, employee.getId());
        em.refresh(employee2);
        tx.commit();
        assertNotNull(employee2);
        assertEquals("Peter", employee2.getName());

        // merge the detached
        tx.begin();
        Employee employee3 = em.merge(employee);
        assertNotNull(employee3);
        assertEquals("Peter 2nd", employee3.getName());
        tx.commit();

        assertNotNull(employee2);
        assertEquals("Peter", employee2.getName());

        employee2 = em.find(Employee.class, employee.getId());

        assertNotNull(employee2);
        assertEquals("Peter 2nd", employee2.getName());
    }

}
