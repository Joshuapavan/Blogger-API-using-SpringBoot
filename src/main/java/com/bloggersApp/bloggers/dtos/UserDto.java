package com.bloggersApp.bloggers.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int id;
    private String userName;
    private String email;
    private String password;
    private String about;
}
