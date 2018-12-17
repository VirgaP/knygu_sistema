package it.akademija.repository;

import it.akademija.dao.UserDao;
import it.akademija.dto.UserServiceDTO;
import it.akademija.entity.Cart;
import it.akademija.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Repository
@Qualifier("dbUser")
public class DBUserDAO implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u from User u", User.class).getResultList();
    }

    @Override
    public User getUser(String username) {
         User user = entityManager
                .createQuery("SELECT u from User u where username = :un", User.class)
                .setParameter("un", username).getSingleResult();

         return user;
    }

    @Override
    public void createUser(UserServiceDTO userServiceDTO, Cart cart) {
        User user = new User(
                userServiceDTO.getId(),
                userServiceDTO.getUsername(),
                userServiceDTO.getFirstName(),
                userServiceDTO.getLastName(),
                userServiceDTO.getEmail(),
                new Date());
        user.setCart(cart);
        entityManager.persist(user);

    }

    @Override
    public void deleteUser(String username) {
        User user = entityManager
                .createQuery("SELECT u from User u where username = :un", User.class)
                .setParameter("un", username).getSingleResult();
        if (entityManager.contains(user)) { entityManager.remove(user); }
        else { entityManager.remove(entityManager.merge(user)); }

    }
}
