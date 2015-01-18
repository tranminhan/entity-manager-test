package org.antran.jdbc;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by atran on 1/18/15.
 */
@Component
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(String username) {
        final Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username");
        query.setParameter("username", username);
        return (User) query.getSingleResult();
    }

    @Override
    public List<User> getUsers() {
        final Query query = entityManager.createQuery("from User");
        return query.getResultList();
    }
}
