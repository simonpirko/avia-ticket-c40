package by.tms.aviaticket.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferCreateDto {
    @NotNull(message = "Введите корректную дату")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateOfDeparture;

    @NotNull(message = "Введите корректную дату")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateOfArrival;

    @Min(1)
    private long airplaneId;

    @NotBlank
    private String placeOfDeparture;

    @NotBlank
    private String placeOfArrival;

    @Min(1)
    @Max(20000)
    private int distance;
}
