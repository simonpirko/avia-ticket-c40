package by.tms.aviaticket.service;

import by.tms.aviaticket.service.exception.UserDataException;
import by.tms.aviaticket.dao.UserDao;
import by.tms.aviaticket.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    private UserDao userDao;

    public void add(User user) {
        if (userDao.containsByEmail(user.getEmail())) {
            throw new UserDataException("A user with this email already exists!");
        }
        userDao.add(user);
    }


    public User userAuth(String email, String password) {
        User user = userDao.getByEmail(email);
        if (user == null) {
            throw new UserDataException("A user with this email doesn't exists!");
        }
        if (!user.getPassword().equals(password)){
            throw new UserDataException("Invalid password");
        }
        return user;
    }

}
