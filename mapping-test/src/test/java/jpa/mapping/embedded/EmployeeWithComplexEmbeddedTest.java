package jpa.mapping.embedded;

import static org.junit.Assert.*;
import jpa.mapping.basic.PersistenceTest;
import jpa.mapping.relationship.Department;
import jpa.mapping.relationship.EmployeeWithRelationship;

import org.junit.Test;

public class EmployeeWithComplexEmbeddedTest extends PersistenceTest {

    @Test
    public void shouldCreateEmployee() {
        entityManager.getTransaction().begin();
        EmployeeWithComplexEmbedded employee = new EmployeeWithComplexEmbedded();
        employee.setName("employee 2");
        employee.setSalary(200L);
        
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setResidence(new EmbeddedAddress("617 B Second Street", "Petaluma", "CA", "94952"));
        contactInfo.setPrimaryPhone(new EmbeddedPhone("123"));
        
        employee.setContactInfo(contactInfo);        

        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        System.out.println(employee.getId());
        assertNotNull(employee.getId());
    }
}
