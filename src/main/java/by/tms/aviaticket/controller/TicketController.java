package by.tms.aviaticket.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ticket")
public class TicketController {

    @GetMapping//переход на страница для оформления билета
    public String ticketProcessing(){
            return "ticketProcessing";
    }
}
