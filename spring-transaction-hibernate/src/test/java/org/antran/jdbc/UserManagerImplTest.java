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