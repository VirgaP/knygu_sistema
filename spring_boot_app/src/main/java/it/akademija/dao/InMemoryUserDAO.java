package it.akademija.dao;

import it.akademija.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//@Repository
public class InMemoryUserDAO   {

//    private final List<User> users = new CopyOnWriteArrayList<>();
//    private List<User> users;
//
//    public InMemoryUserDAO() {
//        users = new ArrayList<User>();
//        User user1 = new User(3, "user1","Marvelous", "Maisel", "maisel@gaslight.com");
//        User user2 = new User(4, "user2","Sandy", "Manager", "sandy@gaslight.com");
//        users.add(user1);
//        users.add(user2);
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        return Collections.unmodifiableList(users);
//    }
//
//    @Override
//    public User getUser(String username) {
//
//        User result = null;
//        for (User temp : users) {
//            if (username.equals(temp.getUsername())) {
//                result = temp;
//            }
//        }
//        return result;
//    }
//
//
//    @Override
//    public void createUser(User user) {
//        users.add(user);
//    }
//
//    @Override
//    public void deleteUser(String username) {
//        for (User user: users) {
//            if (username.equals(user.getUsername())) {
//                users.remove(user);
//                break; }
//        }
//
//    }
}
