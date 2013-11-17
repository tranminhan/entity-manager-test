package jpa.concurrent;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

import jpa.em.app.Employee;

@Stateless
public class SalaryReportBean {

    @PersistenceContext(name = "entity.manager")
    EntityManager      entityManager;

    @EJB
    UpdateEmployeeBean updateEmployeeBean;
 
    public Long totalSalary(Employee employeeToChange) {
        List<Employee> resultList = entityManager.createQuery("SELECT e FROM Employee e").getResultList();
        Long result = 0L;
        for (Employee emp : resultList) {
            entityManager.lock(emp, LockModeType.OPTIMISTIC);
            result += emp.getSalary();
        }
        
        updateEmployeeBean.updateEmployee(employeeToChange.getId());
        
        return result;
    }
}
