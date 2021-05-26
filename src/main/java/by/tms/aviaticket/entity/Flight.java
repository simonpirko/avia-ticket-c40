package by.tms.aviaticket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    private int id;
    private LocalDateTime dateOfDeparture;
    private Airplane airplane;
    private LocalDateTime dateOfArrival;
}
