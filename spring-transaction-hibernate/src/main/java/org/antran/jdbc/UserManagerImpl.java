package org.antran.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by atran on 1/18/15.
 */
@Service
public class UserManagerImpl implements UserManager {
    @Autowired
    UserDao userDao;

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public User getUser(String username) {
        return userDao.getUser(username);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
