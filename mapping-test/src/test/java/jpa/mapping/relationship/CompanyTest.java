package jpa.mapping.relationship;

import static org.junit.Assert.*;
import jpa.mapping.basic.PersistenceTest;

import org.junit.Test;

public class CompanyTest extends PersistenceTest {

    @Test
    public void shouldCreateCompany() {
        entityManager.getTransaction().begin();
        Company company = new Company("KMS");
        company.setAddress(new Address("street1", "city", "state", "zipCode"));
        entityManager.persist(company);
        entityManager.getTransaction().commit();
    }

}
