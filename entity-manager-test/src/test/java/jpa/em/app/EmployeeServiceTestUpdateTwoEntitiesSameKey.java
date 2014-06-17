package jpa.em.app;

import static org.junit.Assert.*;

import javax.ejb.EJB;
import javax.persistence.OptimisticLockException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.junit.Before;
import org.junit.Test;

public class EmployeeServiceTestUpdateTwoEntitiesSameKey extends
		ContainerAndPersistentTest {

	@Before
	public void setup() {
		super.setup();
	}

	@EJB
	EmployeeService employeeService;

	@Test(expected = OptimisticLockException.class)
	public void shouldUpdateEntitiesWithSameKey() throws NotSupportedException,
			SystemException, IllegalStateException, SecurityException,
			HeuristicMixedException, HeuristicRollbackException,
			RollbackException {
		// create an entity
		Employee employee = employeeService.newEmployee("Peter");
		assertNotNull(employee);
		assertEquals("Peter", employee.getName());

		// now it is detached
		employee.setName("Peter 2nd");
		assertEquals("Peter 2nd", employee.getName());

		// find the employee from db
		Employee peter_1 = em.find(Employee.class, employee.getId());
		peter_1.setName("Peter 1st change");
		System.out.println("peter_1 after change name: "
				+ ReflectionToStringBuilder.toString(peter_1));

		Employee peter_2 = em.find(Employee.class, employee.getId());
		peter_2.setName("Peter 2nd change");
		System.out.println("peter_1 after change name: "
				+ ReflectionToStringBuilder.toString(peter_1));
		System.out.println("peter_2 after change name: "
				+ ReflectionToStringBuilder.toString(peter_2));

		tx.begin();
		peter_1 = em.merge(peter_1);
		tx.commit();

		tx.begin();
		peter_2 = em.merge(peter_2);
		tx.commit();

		System.out.println(ReflectionToStringBuilder.toString(peter_1));
		System.out.println(ReflectionToStringBuilder.toString(peter_2));

	}

}
