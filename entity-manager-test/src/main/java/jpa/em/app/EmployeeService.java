package jpa.em.app;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class EmployeeService {

    @Resource
    UserTransaction      tx;

    @PersistenceUnit(unitName = "entity.manager")
    EntityManagerFactory emf;

    public Employee newEmployee(String name) {
        try {
            tx.begin();
            EntityManager em = emf.createEntityManager();
            Employee employee = new Employee(name);
            em.persist(employee);
            tx.commit();
            em.close();

            return employee;
        }
        catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public Employee findEmployee(Integer id) {
        EntityManager em = emf.createEntityManager();
        Employee employee = em.find(Employee.class, id);
        em.close();
        return employee;
    }

    public Employee changeName(Integer id, String newName) {
        try {
            EntityManager em = emf.createEntityManager();
            Employee employee = em.find(Employee.class, id);
            // tx.begin();
            employee.setName(newName);
            // tx.commit();
            em.close();

            return employee;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
