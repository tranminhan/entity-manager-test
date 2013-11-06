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

    public Employee newEmployee(String name, Address address) {
        try {
            tx.begin();
            EntityManager em = emf.createEntityManager();
            Employee employee = new Employee(name);
            employee.setAddress(address);
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

    public Employee newEmployeeAfterPersist(String name, Address address) {
        try {
            tx.begin();
            EntityManager em = emf.createEntityManager();
            Employee employee = new Employee(name);
            em.persist(employee);

            employee.setAddress(address);
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
            tx.begin();
            EntityManager em = emf.createEntityManager();
            Employee employee = em.find(Employee.class, id);
            employee.setName(newName);
            em.close();
            tx.commit();

            return employee;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Employee changeNameWithNoJoin(Employee employee, String newName) {
        try {
            EntityManager em = emf.createEntityManager();
            employee.setName(newName);
            em.persist(employee);
            em.close();

            return employee;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Employee changeNameWithJoinTransaction(Employee employee, String newName) {
        try {

            EntityManager em = emf.createEntityManager();
            employee = em.merge(employee);
            employee.setName(newName);

            tx.begin();
            em.joinTransaction();
            tx.commit();
            em.close();

            return employee;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
