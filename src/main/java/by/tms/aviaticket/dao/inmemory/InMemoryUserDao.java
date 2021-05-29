package by.tms.aviaticket.dao.inmemory;

import by.tms.aviaticket.dao.UserDao;
import by.tms.aviaticket.entity.User;

import java.util.List;

public class InMemoryUserDao implements UserDao {
    @Override
    public void add(User user) {

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
        return false;
    }

    @Override
    public void updatePassword(long id, String password) {

    }
}
