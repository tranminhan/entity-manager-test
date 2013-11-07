package jpa.inheritance.mix;

import static org.junit.Assert.*;
import jpa.inheritance.pertable.PTContractEmployee;
import jpa.inheritance.pertable.PTFullTimeEmployee;
import jpa.inheritance.pertable.PTPartTimeEmployee;
import jpa.mapping.basic.PersistenceTest;

import org.junit.Test;

public class MixEmployeeTest extends PersistenceTest {

    @Test
    public void shouldCreateEmployee() {
        entityManager.getTransaction().begin();
        MixContractEmployee contractEmployee = new MixContractEmployee("contractor", 10);
        entityManager.persist(contractEmployee);

        MixPartTimeEmployee partimeEmployee = new MixPartTimeEmployee("partime student", 5.9f);
        entityManager.persist(partimeEmployee);

        MixFullTimeEmployee fullTimeEmployee = new MixFullTimeEmployee("employee", 100l, 10l);
        entityManager.persist(fullTimeEmployee);

        entityManager.getTransaction().commit();

    }

}
