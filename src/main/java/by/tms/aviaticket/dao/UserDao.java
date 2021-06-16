package by.tms.aviaticket.dao;

import by.tms.aviaticket.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void add(User user);
    List<User> getAll();
    Optional<User> getById(long id);
    User getByUsername(String username);
    Optional<User> getByEmail(String email);
    void remove(long id);
    void updatePhoneNumber(long id,String email);
    void updateFName(long id,String fname);
    void updateLName(long id,String lname);
    void updateSex(long id,String sex);
    boolean contains(String username);
    boolean containsByEmail(String email);
    void updatePassword(long id,String password);

}
