package jpa.inheritance.pertable;

import static org.junit.Assert.*;
import jpa.inheritance.singletable.STContractEmployee;
import jpa.inheritance.singletable.STFullTimeEmployee;
import jpa.inheritance.singletable.STPartTimeEmployee;
import jpa.mapping.basic.PersistenceTest;

import org.junit.Test;

public class PTEmployeeTest extends PersistenceTest {

    @Test
    public void shouldCreateEmployee() {
        entityManager.getTransaction().begin();
        PTContractEmployee contractEmployee = new PTContractEmployee("contractor", 10);
        entityManager.persist(contractEmployee);

        PTPartTimeEmployee partimeEmployee = new PTPartTimeEmployee("partime student", 5.9f);
        entityManager.persist(partimeEmployee);

        PTFullTimeEmployee fullTimeEmployee = new PTFullTimeEmployee("employee", 100l, 10l);
        entityManager.persist(fullTimeEmployee);

        entityManager.getTransaction().commit();

    }

}
