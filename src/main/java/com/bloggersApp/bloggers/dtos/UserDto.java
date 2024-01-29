package com.bloggersApp.bloggers.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int id;
    @NotNull
    private String userName;
    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String about;
}
