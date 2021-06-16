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
    private String email;
    private String phoneNumber;
    private String password;
    private int miles;
}
