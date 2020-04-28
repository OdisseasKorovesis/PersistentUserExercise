/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Odisseas KD
 */
public class UserDaoImpl implements IUserDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public UserDaoImpl() {
        emf = Persistence.createEntityManagerFactory("PersistentUserPU");
        em = emf.createEntityManager();
    }

    @Override
    public User findById(int id) {
        User user = em.find(User.class, id);
        return user;
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public boolean deleteById(int id) {
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        if(user != null) {
            em.remove(user);
            em.getTransaction().commit();            
            return true;
        } else {
            em.getTransaction().commit();
            return false;
        }
    }

    @Override
    public void save(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();        
    }

    @Override
    public User update(int id, User user) {
        User userToUpdate = em.find(User.class, id);
        if(userToUpdate != null) {
            em.getTransaction().begin();
            userToUpdate.setFirstName(user.getFirstName());
            userToUpdate.setLastName(user.getLastName());
            userToUpdate.setTel(user.getTel());
            userToUpdate.setEmail(user.getEmail());
            em.getTransaction().commit();
            return userToUpdate;
        }
        return null;
    }
    
    
}
