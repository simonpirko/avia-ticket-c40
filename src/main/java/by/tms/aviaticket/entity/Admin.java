package by.tms.aviaticket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin{
    private long id;
    private String username;
    private String fname;
    private String lname;
    private String password;
    private Role role;
}
