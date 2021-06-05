package by.tms.aviaticket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends Passenger {
    private long id;
    @Pattern(regexp = "\\b[a-zA-Z0-9._%-]+@[a-zA-Z]+\\.[a-zA-Z]{2,3}\\b", message = "The field must be in the format of an email address")
    private String email;
    private String phoneNumber;
    private String username;
    @NotBlank(message = "Password cannot be empty")
    private String password;
    private int miles;
    private int flightCount;
    private List<Order> orderList;
}
