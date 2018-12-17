package it.akademija.dao;

import it.akademija.dto.UserServiceDTO;
import it.akademija.entity.Cart;
import it.akademija.entity.User;
import it.akademija.service.UserService;

import java.util.List;


    /*
     * DAO - Data Access Object. Darbo su User objektais API.
     */
    public interface UserDao {
        List<User> getAllUsers();
        public User getUser(String username);
        void createUser(UserServiceDTO userServiceDTO, Cart cart);
        void deleteUser(String username);
    }

