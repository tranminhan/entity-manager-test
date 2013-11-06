package jpa.em.app;

import java.util.Properties;

import javax.annotation.Resource;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

import org.junit.After;
import org.junit.Before;

public class ContainerAndPersistentTest {

    @PersistenceContext
    protected EntityManager        em;

    @PersistenceUnit(unitName = "entity.manager")
    protected EntityManagerFactory emf;

    @Resource
    UserTransaction                tx;

    @Before
    public void setup() {
        try {
            final Properties p = new Properties();
            p.put("datasource", "new://Resource?type=DataSource");
            p.put("datasource.JdbcDriver", "org.apache.derby.jdbc.EmbeddedDriver");
            p.put("datasource.JdbcUrl", "jdbc:derby:memory:EmployeesDB;create=true");
            // <property name="javax.persistence.jdbc.driver" value="org.apache.derby.jdbc.EmbeddedDriver" />
            // <property name="javax.persistence.jdbc.url" value="jdbc:derby:memory:EmployeesDB;create=true" />
            // <property name="javax.persistence.jdbc.user" value="" />
            // <property name="javax.persistence.jdbc.password" value="" />
            // <property name="eclipselink.target-database" value="Derby" />

            EJBContainer.createEJBContainer(p).getContext().bind("inject", this);
        }
        catch (NamingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @After
    public void teardown() {

    }

}
