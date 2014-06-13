package jpa.query;

import static org.junit.Assert.*;

import javax.ejb.EJB;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jpa.em.app.Address;
import jpa.em.app.ContainerAndPersistentTest;
import jpa.em.app.Department;
import jpa.em.app.Employee;
import jpa.em.app.EmployeeService;

import org.junit.Before;
import org.junit.Test;

public class QueryMultipleRootTest extends ContainerAndPersistentTest {
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
    public void shouldQueryDepartmentHaveEmployees() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Department> criteriaQuery = criteriaBuilder.createQuery(Department.class);
        Root<Department> dept = criteriaQuery.from(Department.class);
        Root<Employee> emp = criteriaQuery.from(Employee.class);

        criteriaQuery.select(dept)
                .distinct(true)
                .where(criteriaBuilder.equal(dept, emp.get("department")));
    }
    
    @Test
    public void shouldQueryEmployeeInNewYork() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> emp = criteriaQuery.from(Employee.class);

        criteriaQuery.select(emp)
                .where(criteriaBuilder.equal(emp.get("address").get("city"), "New York"));
    }

}
