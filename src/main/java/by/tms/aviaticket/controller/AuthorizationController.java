package by.tms.aviaticket.controller;

import by.tms.aviaticket.service.exception.UserDataException;
import by.tms.aviaticket.service.UserService;
import by.tms.aviaticket.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/home")
public class AuthorizationController {

    @Autowired
    private UserService userService;

    @GetMapping("/reg")
    public String viewRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/reg")
    public String viewRegistrationPage(@Valid User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        try {
            userService.add(user);
        } catch (UserDataException e) {
            model.addAttribute("message", e.getMessage());
            return "registration";
        }

        return "redirect:/home/auth";
    }

    @GetMapping("/auth")
    public String viewPage(Model model) {
        model.addAttribute("user", new User());
        return "authorization";
    }

    @PostMapping("/auth")
    public String viewPage(@Valid User user, BindingResult bindingResult, Model model, HttpSession session) {

        if (bindingResult.hasErrors()) {
            return "authorization";
        }

        try {
            User correctUser = userService.userAuth(user.getEmail(), user.getPassword());
            session.setAttribute("user", correctUser);
        } catch (UserDataException e) {
            model.addAttribute("message", e.getMessage());
            return "authorization";
        }

        return "authorization";
    }

    @GetMapping("/exit")
    public String viewExitPage(HttpSession session) {
        session.invalidate();
        return "home";
    }
}
