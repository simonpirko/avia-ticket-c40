package by.tms.aviaticket.dao;

import by.tms.aviaticket.entity.Admin;

import java.util.Optional;

public interface AdminDao {
    Optional<Admin> getByUsername(String username);
    boolean contains(String username, String password);

}
