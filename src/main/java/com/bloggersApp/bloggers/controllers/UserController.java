package com.bloggersApp.bloggers.controllers;

import com.bloggersApp.bloggers.dtos.UserDto;
import com.bloggersApp.bloggers.responsePayloads.ApiResponse;
import com.bloggersApp.bloggers.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse> createUser(@Valid  @RequestBody UserDto userDto){
        return new ResponseEntity<>(new ApiResponse("Created user", true, this.userService.createUser(userDto)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getUser(@PathVariable int id){
        return new ResponseEntity<>(new ApiResponse("Successfully retrieved user with id: "+id,true,this.userService.getUserById(id)), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable int id,@Valid @RequestBody UserDto userDto){
        return new ResponseEntity<>(new ApiResponse("Successfully updated user with id : "+id, true, this.userService.updateUser(userDto, id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable int id){
        this.userService.deleteUser(id);
//        return new ResponseEntity<>(Map.of("message","Deleted User with ID : "+id), HttpStatus.OK);
//        Or
        return new ResponseEntity<>(new ApiResponse("Deleted user with Id: "+id, true, ""), HttpStatus.OK);
    }


}
