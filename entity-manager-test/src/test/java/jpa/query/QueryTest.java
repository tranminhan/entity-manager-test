package jpa.query;

import static org.junit.Assert.*;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jpa.em.app.Address;
import jpa.em.app.ContainerAndPersistentTest;
import jpa.em.app.Employee;
import jpa.em.app.EmployeeService;

import org.junit.Before;
import org.junit.Test;

public class QueryTest extends ContainerAndPersistentTest {
    @EJB
    EmployeeService employeeService;

    @Before
    public void setup() {
        super.setup();

        employeeService.newEmployee("Peter", new Address("617 B Second Street", "CA", "Petaluma", "94952"));
        employeeService.newEmployee("Robert", new Address("617 B Second Street", "CA", "Petaluma", "94952"));
        employeeService.newEmployee("Kelvin", new Address("617 B Second Street", "CA", "Petaluma", "94952"));
    }

    @Test
    public void shouldQueryEmployeeByName() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> emp = criteriaQuery.from(Employee.class);
        CriteriaQuery<Employee> employeePeter = criteriaQuery.select(emp)
                .where(criteriaBuilder.equal(emp.get("name"), "Peter"));

        TypedQuery<Employee> result = em.createQuery(employeePeter);
        assertNotNull(result);
        List<Employee> resultList = result.getResultList();
        assertNotNull(resultList);

        System.out.println(resultList.size());
        assertEquals(1, resultList.size());
    }
    
   
}
