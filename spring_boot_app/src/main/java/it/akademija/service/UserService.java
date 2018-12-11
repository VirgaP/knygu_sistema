package it.akademija.service;

import it.akademija.dto.UserDTO;
import it.akademija.dao.UserDao;
import it.akademija.dto.UserServiceDTO;
import it.akademija.entity.User;
import it.akademija.model.CreateUserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    @Qualifier("DBUserDAO")
    private UserDao userDao; //atiduoda user is duomenu bazes

    @Transactional
    public List<CreateUserCommand> getUsers() {
        List<CreateUserCommand> createUserCommandList = userDao.getAllUsers()
                .stream()
                .map(user -> new CreateUserCommand(user.getEmail(), user.getUsername(), user.getFirstName(), user.getLastName()))
                .collect(Collectors.toList());
        return  createUserCommandList;
    }
    @Transactional
    public UserDTO getUserByUsername(String username){ //frontended grazins tik username ir email
        User user = userDao.getUser(username);
        UserDTO userDTO = new UserDTO(user.getUsername(), user.getEmail());
        return userDTO;
    }
    @Transactional
    public void createUser(CreateUserCommand cmd) {
        UserServiceDTO userServiceDTO = new UserServiceDTO(
                cmd.getUsername() + (Math.floor(Math.random() * 100)+1),
                cmd.getUsername(),
                cmd.getLastName(),
                cmd.getFirstName(),
                cmd.getEmail()
                );
        userDao.createUser(userServiceDTO);
    }




    @Transactional
    public void deleteUser(String username){
        userDao.deleteUser(username);
    }
}
