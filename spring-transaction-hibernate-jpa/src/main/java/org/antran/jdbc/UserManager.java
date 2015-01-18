package org.antran.jdbc;

import java.util.List;

/**
 * Created by atran on 1/18/15.
 */
public interface UserManager {
    void insertUser(User user);

    User getUser(String username);

    List<User> getUsers();
}
