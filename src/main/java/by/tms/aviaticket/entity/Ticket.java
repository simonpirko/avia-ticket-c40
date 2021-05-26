package by.tms.aviaticket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    private long id;
    private List<Flight> flight;
    private BigDecimal price;
    private String type;
    private int number;
    private User user;
    private LocalDateTime buyTime;

}
