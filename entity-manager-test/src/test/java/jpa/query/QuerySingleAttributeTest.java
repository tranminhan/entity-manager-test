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

public class QuerySingleAttributeTest extends ContainerAndPersistentTest {
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
    public void shouldQueryEmployeeName() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<Employee> emp = criteriaQuery.from(Employee.class);
        CriteriaQuery<String> employeeName = criteriaQuery.select(emp.<String> get("name"));

        TypedQuery<String> result = em.createQuery(employeeName);
        List<String> resultList = result.getResultList();
        System.out.println(resultList.size());
        assertEquals(3, resultList.size());
    }

}
