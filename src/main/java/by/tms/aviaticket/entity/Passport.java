package by.tms.aviaticket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passport {
    private int id;
    private String series;
    private String number;
    private String fname;
    private String lname;
    private String sex;
    private int age;
    private LocalDate dateOfBirth;
    private LocalDate dateOfIssue;
}
