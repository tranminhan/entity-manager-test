package jpa.concurrent;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UpdateEmployeeBean {

    @PersistenceContext(name = "entity.manager")
    EntityManager   entityManager;

    @Resource
    UserTransaction tx;

    public void updateEmployee(Integer id) {
        try {
            tx.begin();

            entityManager
                    .createQuery("UPDATE Employee e SET e.name = 'Sam' WHERE e.id = " + id)
                    .executeUpdate();

            tx.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
