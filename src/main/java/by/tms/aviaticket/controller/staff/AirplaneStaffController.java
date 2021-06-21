package by.tms.aviaticket.controller.staff;

import by.tms.aviaticket.entity.Airplane;
import by.tms.aviaticket.service.exception.AirplaneNotFoundException;
import by.tms.aviaticket.service.staff.AirplaneStaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Controller
@RequestMapping("/staff/airplane")
public class AirplaneStaffController {
    private final AirplaneStaffService airplaneStaffService;

    public AirplaneStaffController(AirplaneStaffService airplaneStaffService) {
        this.airplaneStaffService = airplaneStaffService;
    }

    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("list", airplaneStaffService.getAll());
        return "staff/getAirplane";
    }

    @GetMapping("/create")
    public String createView(Model model) {
        model.addAttribute("airplane", new Airplane());
        return "staff/createAirplane";
    }

    @PostMapping("/create")
    public String createHandler(
            @ModelAttribute("airplane") @Valid Airplane airplane,
            BindingResult bindingResult,
            Model model
    ) {
        if(!bindingResult.hasErrors()) {
            airplaneStaffService.create(airplane);
            model.addAttribute("message", "Самалет успешно добавлен");
        }
        return "staff/createAirplane";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable @Min(1) Long id, Model model) {
        try {
            model.addAttribute("airplane", airplaneStaffService.get(id));
            return "staff/updateAirplane";
        } catch (AirplaneNotFoundException e) {
            model.addAttribute("message", "Самалет не найден");
            return "redirect:/staff/airplane";
        }
    }

    @PostMapping("/update/{id}")
    public String updateHandler(
            @ModelAttribute("airplane") @Valid Airplane airplane,
            BindingResult bindingResult,
            @PathVariable @Min(1) Long id,
            Model model
    ) {
        if(!bindingResult.hasErrors()) {
            try {
                airplaneStaffService.update(id, airplane);
                model.addAttribute("message", "Данные самалет успешно обновлены");
            } catch (AirplaneNotFoundException e) {
                model.addAttribute("message", "Самалет не найден");
            }
        }
        return "staff/updateAirplane";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable @Min(1) Long id, Model model) {
        try {
            airplaneStaffService.delete(id);
            model.addAttribute("message", "Самалет успешно удален");
        } catch (AirplaneNotFoundException e) {
            model.addAttribute("message", "Самалет не найден");
        }
        return "redirect:/staff/airplane";
    }
}
