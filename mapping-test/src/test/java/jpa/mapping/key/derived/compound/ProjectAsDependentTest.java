package jpa.mapping.key.derived.compound;

import static org.junit.Assert.*;
import jpa.mapping.basic.PersistenceTest;

import org.junit.Test;

public class ProjectAsDependentTest extends PersistenceTest {

    @Test
    public void test() {
        entityManager.getTransaction().begin();        
        DepartmentWithDependent department = new DepartmentWithDependent("VN", 1, "HR");
        entityManager.persist(department);        
        ProjectAsDependent project = new ProjectAsDependent("MarketLive", department);
        entityManager.persist(project);        
        entityManager.getTransaction().commit();
        
        
        DepartmentWithDependent department2 = entityManager.find(DepartmentWithDependent.class, new DepartmentId("VN", 1));
        assertNotNull(department2);
    }

}
