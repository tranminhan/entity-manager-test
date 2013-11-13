package jpa.query;

import static org.junit.Assert.*;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.Tuple;
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

public class QueryMultipleAttributeTest extends ContainerAndPersistentTest {
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
    public void shouldQueryEmployeeIdAndName() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
        Root<Employee> emp = criteriaQuery.from(Employee.class);
        CriteriaQuery<Tuple> employeeName = criteriaQuery.multiselect(emp.get("id"), emp.get("name"));

        TypedQuery<Tuple> result = em.createQuery(employeeName);
        List<Tuple> resultList = result.getResultList();
        System.out.println(resultList.size());
        assertEquals(3, resultList.size());
        for(Tuple tuple : resultList) {
            System.out.println(tuple.get(0) + "\t" + tuple.get(1));
        }
    }

}
