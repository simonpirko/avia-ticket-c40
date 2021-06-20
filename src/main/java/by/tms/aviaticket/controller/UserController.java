package by.tms.aviaticket.controller;

import by.tms.aviaticket.entity.*;
import by.tms.aviaticket.entity.dto.UserChangeDataDto;
import by.tms.aviaticket.entity.dto.UserLoginDto;
import by.tms.aviaticket.entity.dto.UserPasswordEditDto;
import by.tms.aviaticket.entity.dto.UserRegDto;
import by.tms.aviaticket.service.OrderService;
import by.tms.aviaticket.service.exception.UserDataException;
import by.tms.aviaticket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/reg")
    public String viewRegistrationPage(Model model) {
        model.addAttribute("user", new UserRegDto());
        return "user/registration";
    }

    @PostMapping("/reg")
    public String viewRegistrationPage(@Valid @ModelAttribute("user") UserRegDto dto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "user/registration";
        }

        try {
            userService.add(dto);
        } catch (UserDataException e) {
            model.addAttribute("message", e.getMessage());
            return "user/registration";
        }

        return "redirect:/user/login";
    }

    @GetMapping("/login")
    public String viewPage(Model model) {
        model.addAttribute("user", new UserLoginDto());
        return "user/authorization";
    }

    @PostMapping("/login")
    public String viewPage(@Valid @ModelAttribute("user") UserLoginDto dto, BindingResult bindingResult, Model model, HttpSession session) {

        if (bindingResult.hasErrors()) {
            return "user/authorization";
        }

        try {
            User correctUser = userService.userAuth(dto);
            session.setAttribute("user", correctUser);
        } catch (UserDataException e) {
            model.addAttribute("message", e.getMessage());
            return "user/authorization";
        }

        return "redirect:/user/profile";
    }

    @GetMapping("/exit")
    public String viewExitPage(HttpSession session) {
        session.invalidate();
        return "home";
    }

    @GetMapping("/profile")
    public String getProfile() {
        return "user/profile";
    }

    @GetMapping("/profile/edit")
    public String editProfile(Model model) {
        model.addAttribute("user", new UserChangeDataDto());
        return "user/profileEdit";
    }

    @PostMapping("/profile/edit")
    public String editProfile(@Valid @ModelAttribute("user") UserChangeDataDto dto,
                              BindingResult bindingResult,
                              Model model,
                              HttpSession session) {

        if (bindingResult.hasErrors()) {
            return "user/profileEdit";
        }

        try{
            User user = userService.changeData((User) session.getAttribute("user"), dto);
            session.setAttribute("user", user);
        }catch (UserDataException e){
            model.addAttribute("message", e.getMessage());
            return "user/profileEdit";
        }

        return "redirect:/user/profile";
    }

    @GetMapping("/profile/editPassword")
    public String editPassword(Model model) {
        model.addAttribute("password", new UserPasswordEditDto());
        return "user/editPassword";
    }

    @PostMapping("/profile/editPassword")
    public String editPassword(@Valid @ModelAttribute("password") UserPasswordEditDto dto,
                               BindingResult bindingResult,
                               Model model,
                               HttpSession session) {

        if (bindingResult.hasErrors()) {
            return "user/editPassword";
        }

        try{
            User user = userService.changePassword(dto, (User) session.getAttribute("user"));
            session.setAttribute("user", user);
        }catch (UserDataException e){
            model.addAttribute("message", e.getMessage());
            return "user/editPassword";
        }

        return "redirect:/user/profile";
    }


    @GetMapping("/profile/currentOrders")
    public String getCurrentOrders(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");

        List<Order> currentOrders = orderService.getCurrentOrders(user);
        model.addAttribute("orders", currentOrders);

        return "user/userCurrentOrder";
    }

    @PostMapping("/profile/currentOrders/delete")
    public String deleteOrder(long id, HttpSession session) {
        User user = (User) session.getAttribute("user");

        orderService.remove(id);

        return "redirect:/user/profile/currentOrders";
    }

    @GetMapping("/profile/orderList")
    public String getPaidHistory(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");

        List<Order> currentOrders = orderService.getPaidHistory(user);
        model.addAttribute("orders", currentOrders);

        return "user/userPaidHistory";
    }


}
