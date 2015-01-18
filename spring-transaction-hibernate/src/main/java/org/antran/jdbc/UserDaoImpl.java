package org.antran.jdbc;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by atran on 1/18/15.
 */
@Component
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insertUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User getUser(String username) {
        final Query query = sessionFactory.getCurrentSession().createQuery("from User where username = :username");
        query.setParameter("username", username);
        return (User) query.list().get(0);
    }

    @Override
    public List<User> getUsers() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }
}
