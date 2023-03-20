package com.example.Twitter_Clone20.ResquestDto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotNull(message = "username shouldn't be null")
    private String name;
    private String password;
    @Pattern(regexp = "^\\d{10}$",message = "invalid Mobile Number")
    private String mobile;
    @Email(message = "invalid email Address")
    private String email;
    @Min(value = 18,message = "Your age is Less than 18")
    @Max(value = 100,message = "Your age is Greater than 100")
    private int age;
    private  String gender;
    private Date dob;

}
