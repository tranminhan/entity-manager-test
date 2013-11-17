package jpa.concurrent;

import static org.junit.Assert.*;

import javax.ejb.EJB;

import jpa.em.app.ContainerAndPersistentTest;
import jpa.em.app.Employee;
import jpa.em.app.EmployeeService;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Before;
import org.junit.Test;

public class SalaryReportBeanTest extends ContainerAndPersistentTest {

    @Before
    public void setup() {
        super.setup();
    }

    @EJB
    SalaryReportBean salaryReportBean;

    @EJB
    EmployeeService  employeeService;

    @Test
    public void test() {
        Employee employee = employeeService.newEmployee("Peter", 100L);
        employeeService.newEmployee("David", 200L);

        try {
            Long totalSalary = salaryReportBean.totalSalary(employee);
            System.out.println(totalSalary);
            fail("expect javax.persistence.OptimisticLockException");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        Employee employee2 = em.find(Employee.class, employee.getId());
        System.out.println(ReflectionToStringBuilder.toString(employee2));
    }

}
