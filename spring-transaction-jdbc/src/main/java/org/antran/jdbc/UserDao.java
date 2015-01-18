package org.antran.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by atran on 1/18/15.
 */
public interface UserDao {
    void insertUser(User user);

    User getUser(String username);

    List<User> getUsers();

    JdbcTemplate getTemplate();
}
