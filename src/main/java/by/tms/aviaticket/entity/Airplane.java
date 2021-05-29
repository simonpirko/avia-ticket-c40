package by.tms.aviaticket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Airplane {
    private long id;
    private String brand;
    private String company;
    private int economySeats;
    private int businessSeats;
    private int economyCapacity;
    private int businessCapacity;
}
