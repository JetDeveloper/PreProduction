/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.rentproject.dao.user;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import ua.epam.rentproject.model.User;

/**
 *
 * @author Dmytro_Svynarenko
 */
public class UserDAOImpl implements UserDAO {

    private EntityManager entityManager;

    public UserDAOImpl() {
    }

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> userQuery = entityManager.createNamedQuery("User.getAllUsers", User.class);
        return userQuery.getResultList();
    }

    @Override
    public User getUserById(int id) {
        TypedQuery<User> userQuery = entityManager.createNamedQuery("User.getUserById", User.class);
        userQuery.setParameter("id", id);
        return userQuery.getSingleResult();
    }

    @Override
    public Integer insertUser(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            return user.getUserId();
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
                return null;
            }
        }
    }

    @Override
    public void udpateUser(User user) {
        User temp = entityManager.find(User.class, user.getUserId());
        if (temp == null) {
            insertUser(user);
        } else {
            try {
                entityManager.getTransaction().begin();
                temp.setFullName(user.getFullName());
                temp.setLogin(user.getLogin());
                temp.setPassword(user.getPassword());
                temp.setRegDate(user.getRegDate());
                temp.setRole(user.getRole());
                entityManager.getTransaction().commit();
            } finally {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            }
        }
    }

    @Override
    public void deleteUser(User user) {
        User temp = entityManager.find(User.class, user.getUserId());
        if (temp != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(temp);
                entityManager.getTransaction().commit();
            } finally {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            }
        }
    }
}
