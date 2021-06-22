package by.tms.aviaticket.dao.indatabase;

import by.tms.aviaticket.dao.UserDao;
import by.tms.aviaticket.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InDataBaseUserDao implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void add(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public Optional<User> getById(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return Optional.of(currentSession.find(User.class, id));
    }

    @Override
    public User getByUsername(String username) {
        return null;
    }

    @Override
    public Optional<User> getByEmail(String email) {
        Session currentSession = sessionFactory.getCurrentSession();
        User userEmail = currentSession
                .createQuery("from User where email = :email", User.class)
                .setParameter("email", email)
                .getSingleResult();
        return Optional.of(userEmail);
    }

    @Override
    public void remove(long id) {

    }

    @Override
    public void updatePhoneNumber(long id, String phoneNumber) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession
                .createQuery("from User where id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
        user.setPhoneNumber(phoneNumber);
    }

    @Override
    public void updateFName(long id, String fname) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession
                .createQuery("from User where id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
        user.setFname(fname);
    }

    @Override
    public void updateLName(long id, String lname) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession
                .createQuery("from User where id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
        user.setLname(lname);
    }

    @Override
    public void updateSex(long id, String sex) {

    }

    @Override
    public boolean contains(String username) {
        return false;
    }

    @Override
    public boolean containsByEmail(String email) {
        Session currentSession = sessionFactory.getCurrentSession();
        Long isExistIndicator = currentSession
                .createQuery("select count(*) from User where email = :email", Long.class)
                .setParameter("email", email)
                .uniqueResult();
        return isExistIndicator > 0L;
    }

    @Override
    public void updatePassword(long id, String password) {

    }
}
