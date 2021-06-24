package by.tms.aviaticket.controller;

import by.tms.aviaticket.entity.Flight;
import by.tms.aviaticket.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/")
public class SearchController {
    @Autowired
    @Qualifier("searchService")
    private SearchService searchService;

    @GetMapping
    public String searchView(){
        return "home";
    }


    @GetMapping("search")
    public String searchView(@NotBlank @NotNull String from, @NotBlank @NotNull String to, LocalDate departure, @Min(1) @Max(10) int count, Model model){
        List<Flight> flights = searchService.find(from, to, departure, count);
        if (flights.size() == 0){
            model.addAttribute("searchMessage","Flight not found");
        }
        return "search";
    }
}
