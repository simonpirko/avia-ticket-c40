package by.tms.aviaticket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transfer {
    private long id;
    private LocalDateTime dateOfDeparture;
    private LocalDateTime dateOfArrival;
    private Airplane airplane;
    private String placeOfDeparture;
    private String placeOfArrival;
    private int distance;
}
