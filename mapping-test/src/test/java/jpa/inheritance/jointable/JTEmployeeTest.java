package jpa.inheritance.jointable;

import static org.junit.Assert.*;
import jpa.inheritance.singletable.STContractEmployee;
import jpa.inheritance.singletable.STFullTimeEmployee;
import jpa.inheritance.singletable.STPartTimeEmployee;
import jpa.mapping.basic.PersistenceTest;

import org.junit.Test;

public class JTEmployeeTest extends PersistenceTest {

    @Test
    public void shouldCreateEmployee() {
        entityManager.getTransaction().begin();
        JTContractEmployee contractEmployee = new JTContractEmployee("contractor", 10);
        entityManager.persist(contractEmployee);

        JTPartTimeEmployee partimeEmployee = new JTPartTimeEmployee("partime student", 5.9f);
        entityManager.persist(partimeEmployee);

        JTFullTimeEmployee fullTimeEmployee = new JTFullTimeEmployee("employee", 100l, 10l);
        entityManager.persist(fullTimeEmployee);

        entityManager.getTransaction().commit();

    }
}
