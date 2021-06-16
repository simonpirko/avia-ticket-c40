package by.tms.aviaticket.entity.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPasswordEditDto {
    @NotBlank(message = "Password cannot be empty")
    private String password;
    @Length(min = 3, message = "The field must be at least 3 characters")
    @NotBlank(message = "Password cannot be empty")
    private String newPassword;
    @NotBlank(message = "Password cannot be empty")
    private String confirmPassword;
}
