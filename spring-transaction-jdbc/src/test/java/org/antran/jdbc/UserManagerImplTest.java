package org.antran.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

public class UserManagerImplTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final UserManager userManagerImpl = (UserManager) context.getBean("userManagerImpl");
        assertNotNull(userManagerImpl);

        final UserDao userDaoImpl = (UserDaoImpl) context.getBean("userDaoImpl");
        assertNotNull(userDaoImpl);

        userDaoImpl.getTemplate().execute(
                "CREATE TABLE USERS (" +
                "  ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                "  USERNAME VARCHAR (32) NOT NULL," +
                "  NAME VARCHAR (64) NOT NULL," +
                "  UNIQUE (USERNAME)" +
                ")");

        // insert a user
        User user = new User();
        user.setName("Test 1");
        user.setUsername("Test username");
        userManagerImpl.insertUser(user);

        // query user back
        final User user1 = userManagerImpl.getUser("Test username");
        assertNotNull(user1);
    }
}