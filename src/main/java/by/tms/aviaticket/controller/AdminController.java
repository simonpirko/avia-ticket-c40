package by.tms.aviaticket.controller;

import by.tms.aviaticket.entity.Admin;
import by.tms.aviaticket.entity.dto.AdminLoginDto;
import by.tms.aviaticket.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping
    public String viewPage(Model model){
        model.addAttribute("admin", new AdminLoginDto());
        return "admin";
    }

    @PostMapping
    public String login(@Valid @ModelAttribute("admin") AdminLoginDto dto, Model model, HttpSession session) {
        Optional<Admin> admin = adminService.getAdmin(dto);
        if (admin.isPresent()){
            session.setAttribute("admin",admin.get());
        }else {
            model.addAttribute("message","Invalid password or username");
            return "admin";
        }

        return "redirect:/user/profile";
    }
}
