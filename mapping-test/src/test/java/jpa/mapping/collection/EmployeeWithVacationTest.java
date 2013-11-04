package jpa.mapping.collection;

import static org.junit.Assert.assertNotNull;
import jpa.mapping.basic.PersistenceTest;

import org.junit.Test;

public class EmployeeWithVacationTest extends PersistenceTest {

    @Test
    public void shouldCreateEmployee() {
        entityManager.getTransaction().begin();

        EmployeeWithVacation employee = new EmployeeWithVacation("emp 1", 100L);
        employee.addNickname("nick1");
        employee.addNickname("nick2");
        employee.addNickname("nick3");
        
        employee.addPhone("123");
        
        // employee.bookVacation(new VacationEntry());
        // employee.bookVacation(new VacationEntry(new Date(), 1));
        // employee.bookVacation(new VacationEntry(Calendar.getInstance(), 2));
        // employee.bookVacation(new VacationEntry(Calendar.getInstance(), 3));

        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        System.out.println(employee.getId());
        assertNotNull(employee.getId());

    }

}
