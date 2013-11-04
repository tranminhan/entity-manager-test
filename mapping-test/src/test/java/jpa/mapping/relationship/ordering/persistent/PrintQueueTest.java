package jpa.mapping.relationship.ordering.persistent;

import static org.junit.Assert.*;

import java.util.Collections;

import javax.persistence.EntityManager;

import jpa.mapping.basic.PersistenceTest;

import org.apache.commons.beanutils.BeanComparator;
import org.junit.Test;

public class PrintQueueTest extends PersistenceTest {

    @SuppressWarnings("unchecked")
    @Test
    public void shouldCreateQueue() {
        entityManager.getTransaction().begin();

        PrintQueue queue = new PrintQueue();
        queue.addJob("most important");
        queue.addJob("unimportant");
        queue.addJob("moderate");

        entityManager.persist(queue);
        entityManager.getTransaction().commit();

        // check order
        EntityManager entityManager2 = entityManagerFactory.createEntityManager();
        entityManager2.getTransaction().begin();
        PrintQueue printQueue = entityManager2.find(PrintQueue.class, queue.getId());

        assertNotNull(printQueue);
        assertEquals(3, printQueue.getJobs().size());
        System.out.println("== after retrieved");
        for (PrintJob job : printQueue.getJobs()) {
            System.out.println(job.getName());
        }

        // change order
        Collections.sort(printQueue.getJobs(), new BeanComparator("name"));
        System.out.println("== after sort");
        for (PrintJob job : printQueue.getJobs()) {
            System.out.println(job.getName());
        }
        entityManager2.getTransaction().commit();

        // check order again
        EntityManager entityManager3 = entityManagerFactory.createEntityManager();
        entityManager3.getTransaction().begin();
        printQueue = entityManager3.find(PrintQueue.class, queue.getId());

        assertNotNull(printQueue);
        assertEquals(3, printQueue.getJobs().size());
        System.out.println("== after retrieved again");
        for (PrintJob job : printQueue.getJobs()) {
            System.out.println(job.getName());
        }
    }

}
