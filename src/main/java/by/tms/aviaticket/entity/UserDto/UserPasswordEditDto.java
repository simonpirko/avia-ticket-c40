package by.tms.aviaticket.entity.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPasswordEditDto {
    @NotBlank(message = "Password cannot be empty")
    private String password;
    @NotBlank(message = "Password cannot be empty")
    private String newPassword;
    @NotBlank(message = "Password cannot be empty")
    private String confirmPassword;
}
