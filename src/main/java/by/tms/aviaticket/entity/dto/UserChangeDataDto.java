package by.tms.aviaticket.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserChangeDataDto {
    @NotEmpty
    private String fname;
    @NotEmpty
    private String lname;
    @NotEmpty
    private String phoneNumber;
}
