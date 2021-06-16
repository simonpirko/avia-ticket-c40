package by.tms.aviaticket.entity.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegDto {
    @Pattern(regexp = "\\b[a-zA-Z0-9._%-]+@[a-zA-Z]+\\.[a-zA-Z]{2,3}\\b", message = "The field must be in the format of an email address")
    private String email;
    @NotBlank(message = "Phone number cannot be empty")
    private String phoneNumber;
    @NotBlank(message = "Password cannot be empty")
    private String password;
    @NotBlank(message = "First name cannot be empty")
    private String fname;
    @NotBlank(message = "Last name cannot be empty")
    private String lname;
}
