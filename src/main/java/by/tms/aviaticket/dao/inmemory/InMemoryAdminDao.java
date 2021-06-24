package by.tms.aviaticket.dao.inmemory;

import by.tms.aviaticket.dao.AdminDao;
import by.tms.aviaticket.entity.Admin;
import by.tms.aviaticket.entity.Role;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryAdminDao implements AdminDao {
    private static List<Admin> adminList = new ArrayList<>();

    @Override
    public Optional<Admin> getByUsername(String username) {
        return adminList.stream()
                .filter(admin -> admin.getUsername().equals(username))
                .findFirst()
                .map(Optional::of)
                .orElse(null);
    }

    @Override
    public boolean contains(String username, String password) {
        return adminList.stream()
                .anyMatch(admin -> admin.getUsername().equals(username)
                        && admin.getPassword().equals(password));
    }

    static {
        Admin admin = new Admin();
        admin.setFname("Yuriy");
        admin.setLname("Musienko");
        admin.setId(1);
        admin.setRole(Role.ADMIN);
        admin.setUsername("admin");
        admin.setPassword("1111");

        adminList.add(admin);
    }
}
