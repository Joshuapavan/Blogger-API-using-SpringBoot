package com.bloggersApp.bloggers.services;

import com.bloggersApp.bloggers.dtos.UserDto;

import java.util.List;

//@Service
public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto, Integer id);
    UserDto getUserById(Integer id);
    List<UserDto> getAllUsers();
    void deleteUser(Integer id);
}
