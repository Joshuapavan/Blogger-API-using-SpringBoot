package com.bloggersApp.bloggers.services.impl;

import com.bloggersApp.bloggers.dtos.UserDto;
import com.bloggersApp.bloggers.entities.User;
import com.bloggersApp.bloggers.exceptions.ResourceNotFoundException;
import com.bloggersApp.bloggers.repositories.UserRepo;
import com.bloggersApp.bloggers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDto createUser(UserDto userDto) {
       User user = this.dtoToUser(userDto);
       user.setUserName(userDto.getUserName());
       user.setEmail(userDto.getUserName());
       user.setPassword(userDto.getPassword());
       user.setAbout(userDto.getAbout());
       return this.userToDto(this.userRepo.save(user));
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer id) {
//        Optional<User> user = this.userRepo.findById(id);
        User user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        return this.userToDto(this.userRepo.save(user));
    }

    @Override
    public UserDto getUserById(Integer id) {
//        Optional<User> user = this.userRepo.findById(id);
//        return this.userToDto(user.get());
        User user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        return users.stream().map(this::userToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer id) {
        this.userRepo.deleteById(id);
    }

    private UserDto userToDto(User user){
        return new UserDto(user.getId(), user.getUserName(),
                user.getEmail(), user.getPassword(), user.getAbout());
    }

    private User dtoToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(user.getPassword());

        return user;
    }

}
