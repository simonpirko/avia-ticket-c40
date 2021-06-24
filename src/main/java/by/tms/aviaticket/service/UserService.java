package by.tms.aviaticket.service;

import by.tms.aviaticket.entity.dto.UserChangeDataDto;
import by.tms.aviaticket.entity.dto.UserLoginDto;
import by.tms.aviaticket.entity.dto.UserPasswordEditDto;
import by.tms.aviaticket.entity.dto.UserRegDto;
import by.tms.aviaticket.service.exception.UserDataException;
import by.tms.aviaticket.dao.UserDao;
import by.tms.aviaticket.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;


    public void add(UserRegDto dto) {
        User user = createUser(dto);
        if (userDao.containsByEmail(user.getEmail())) {
            throw new UserDataException("A user with this email already exists!");
        }
        userDao.add(user);
    }


    public User userAuth(UserLoginDto dto) {
        if (!userDao.containsByEmail(dto.getEmail())) {
            throw new UserDataException("A user with this email doesn't exists!");
        }

        Optional<User> byEmail = userDao.getByEmail(dto.getEmail());
        User user = byEmail.get();

        if (!user.getPassword().equals(dto.getPassword())) {
            throw new UserDataException("Invalid password");
        }
        return user;
    }

    public User changeData(User user, UserChangeDataDto dto) {


        if (user.getFname().equals(dto.getFname()) &&
                user.getLname().equals(dto.getLname()) &&
                user.getPhoneNumber().equals(dto.getPhoneNumber())) {
            throw new UserDataException("you haven't made any changes");

        }
        userDao.updateLName(user.getId(), dto.getLname());
        userDao.updateFName(user.getId(), dto.getFname());
        userDao.updatePhoneNumber(user.getId(), dto.getPhoneNumber());

        return userDao.getById(user.getId()).get();
    }

    public User changePassword(UserPasswordEditDto dto, User user) {
        if (!dto.getNewPassword().equals(dto.getConfirmPassword())) {
            throw new UserDataException("the new password is different from the confirmed");
        }

        if (!dto.getPassword().equals(user.getPassword())) {
            throw new UserDataException("Invalid password");
        }

        if (dto.getNewPassword().equals(dto.getPassword())) {
            throw new UserDataException("old password is the same as new");
        }

        userDao.updatePassword(user.getId(), dto.getNewPassword());
        return userDao.getById(user.getId()).get();
    }

    User createUser(UserRegDto dto) {
        User user = new User();
        user.setFname(dto.getFname());
        user.setLname(dto.getLname());
        user.setPassword(dto.getPassword());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setEmail(dto.getEmail());
        return user;
    }


}
