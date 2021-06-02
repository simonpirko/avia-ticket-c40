package by.tms.aviaticket.dao.inmemory;

import by.tms.aviaticket.dao.UserDao;
import by.tms.aviaticket.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryUserDao implements UserDao {
    private final List<User> userList = new ArrayList<>();
    private static int incId = 1;

    @Override
    public void add(User user) {
        user.setId(incId++);
        userList.add(user);
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getById(long id) {
        return null;
    }

    @Override
    public User getByUsername(String username) {
        return null;
    }

    @Override
    public User getByEmail(String email) {
        return userList.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
    }

    @Override
    public void remove(long id) {

    }

    @Override
    public void updateEmail(long id, String email) {

    }

    @Override
    public void updateFName(long id, String fname) {

    }

    @Override
    public void updateLName(long id, String lname) {

    }

    @Override
    public void updateSex(long id, String sex) {

    }

    @Override
    public boolean contains(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsByEmail(String email) {
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void updatePassword(long id, String password) {

    }
}
