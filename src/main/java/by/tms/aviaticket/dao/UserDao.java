package by.tms.aviaticket.dao;

import by.tms.aviaticket.entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> getAll();
    User getById(long id);
    User getByUsername(String username);
    void remove(long id);
    void updateEmail(long id,String email);
    void updateFName(long id,String fname);
    void updateLName(long id,String lname);
    void updateSex(long id,String sex);
    boolean contains(String username);
    void updatePassword(long id,String password);

}
