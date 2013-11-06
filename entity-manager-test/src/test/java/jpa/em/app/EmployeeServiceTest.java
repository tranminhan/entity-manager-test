package jpa.em.app;

import static org.junit.Assert.*;

import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

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

        EntityManager entityManager = emf.createEntityManager();
        Employee employee4 = entityManager.find(Employee.class, employee.getId());
        System.out.println(ReflectionToStringBuilder.toString(employee4));
        assertNotNull(employee4);
    }

    @Test
    public void shouldEditExistingEmployee() throws NotSupportedException, SystemException, IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException,
            RollbackException {
        tx.begin();
        EntityManager entityManager = emf.createEntityManager();
        Employee employee = new Employee("Peter");
        entityManager.persist(employee);
        tx.commit();
        System.out.println(ReflectionToStringBuilder.toString(employee));

        Employee newEmployee = em.find(Employee.class, employee.getId());
        assertNotNull(newEmployee);
        System.out.println(ReflectionToStringBuilder.toString(newEmployee));

        Employee employee2 = employeeService.changeName(employee.getId(), "Hand");
        System.out.println(ReflectionToStringBuilder.toString(employee2));

        entityManager = emf.createEntityManager();
        Employee employee3 = entityManager.find(Employee.class, employee2.getId());
        System.out.println(ReflectionToStringBuilder.toString(employee3));
        assertNotNull(employee3);
    }
}
