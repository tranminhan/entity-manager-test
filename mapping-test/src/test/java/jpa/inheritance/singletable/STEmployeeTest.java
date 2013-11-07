package jpa.inheritance.singletable;

import static org.junit.Assert.*;
import jpa.mapping.basic.PersistenceTest;

import org.junit.Test;

public class STEmployeeTest extends PersistenceTest {

    @Test
    public void shouldCreateEmployee() {
        entityManager.getTransaction().begin();
        STContractEmployee contractEmployee = new STContractEmployee("contractor", 10);
        entityManager.persist(contractEmployee);

        STPartTimeEmployee partimeEmployee = new STPartTimeEmployee("partime student", 5.9f);
        entityManager.persist(partimeEmployee);

        STFullTimeEmployee fullTimeEmployee = new STFullTimeEmployee("employee", 100l, 10l);
        entityManager.persist(fullTimeEmployee);

        entityManager.getTransaction().commit();

    }

}
