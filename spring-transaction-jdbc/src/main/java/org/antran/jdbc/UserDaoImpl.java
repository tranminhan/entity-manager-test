package org.antran.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by atran on 1/18/15.
 */
@Component
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

    @Autowired
    public UserDaoImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public void insertUser(User user) {
        getJdbcTemplate().update("INSERT INTO USERS (USERNAME, NAME) VALUES(?, ?)",
                new Object[]{user.getUsername(), user.getName()});
    }

    @Override
    public User getUser(String username) {
        User user = getJdbcTemplate().queryForObject("SELECT * FROM USERS WHERE USERNAME = ?",
                new Object[]{username},
                new UserMapper());
        return user;
    }

    @Override
    public List<User> getUsers() {
        return getJdbcTemplate().query("SELECT * FROM USERS",
                new UserMapper());
    }

    @Override
    public JdbcTemplate getTemplate() {
        return getJdbcTemplate();
    }

    private class UserMapper implements org.springframework.jdbc.core.RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("ID"));
            user.setUsername(rs.getString("USERNAME"));
            user.setName(rs.getString("NAME"));
            return user;
        }
    }
}
