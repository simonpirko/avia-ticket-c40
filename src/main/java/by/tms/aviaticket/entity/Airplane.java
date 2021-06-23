package by.tms.aviaticket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Airplane {
    private long id;

    @NotBlank(message = "Введите корректно брэнд")
    private String brand;

    @NotBlank(message = "Введите корректно компанию")
    private String company;

    @Min(0)
    @Max(1000)
    private int economySeats;

    @Min(0)
    @Max(1000)
    private int businessSeats;

    @Min(0)
    @Max(1000)
    private int economyCapacity;

    @Min(0)
    @Max(1000)
    private int businessCapacity;
}
