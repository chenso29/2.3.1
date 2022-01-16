package com.chenso2910.DAO;


import com.chenso2910.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }


    @Override
    public void addUser(User user) {
        entityManager.persist(user);
        System.out.println("User " + user.getName() + " добавлен в таблицу");

    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);

    }

    @Override
    public void updateUser(int id, User updatedUser) {
        User userToUpdate = getUser(id);
        userToUpdate.setName(updatedUser.getName());
        userToUpdate.setSurname(updatedUser.getSurname());
        userToUpdate.setAge(updatedUser.getAge());
        entityManager.merge(userToUpdate);

    }

    @Override
    public void deleteUser(int id) {
        User user = getUser(id);
        entityManager.remove(user);
    }


}
