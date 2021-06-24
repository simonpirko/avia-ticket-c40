package by.tms.aviaticket.service;

import by.tms.aviaticket.dao.AdminDao;
import by.tms.aviaticket.entity.Admin;
import by.tms.aviaticket.entity.dto.AdminLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    public Optional<Admin> getAdmin(AdminLoginDto dto) {
        if (adminDao.contains(dto.getUsername(),dto.getPassword())){
            return adminDao.getByUsername(dto.getUsername());
        }else {
            return Optional.empty();
        }
    }
}
