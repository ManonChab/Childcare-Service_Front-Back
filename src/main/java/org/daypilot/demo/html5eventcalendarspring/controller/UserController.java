package org.daypilot.demo.html5eventcalendarspring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import org.daypilot.demo.html5eventcalendarspring.Entity.Review;
import org.daypilot.demo.html5eventcalendarspring.Entity.User;
import org.daypilot.demo.html5eventcalendarspring.dto.RequestDTO.LoginRequestDTO;
import org.daypilot.demo.html5eventcalendarspring.dto.RequestDTO.UserRequestDTO;
import org.daypilot.demo.html5eventcalendarspring.dto.ResponseDTO.UserResponseDTO;
import org.daypilot.demo.html5eventcalendarspring.mappper.UserMapper;
import org.daypilot.demo.html5eventcalendarspring.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(
        @RequestBody UserRequestDTO user) {
        System.out.println("Received user DTO: " + user);
        UserResponseDTO newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable int id) {
    User user = userService.getUserById(id);
    UserResponseDTO userDTO = userMapper.toResponseDTO(user);
    return ResponseEntity.ok()
    .header("Authorization", "Bearer ")
    .body(userDTO);
    }

   @GetMapping("/profile/{id}")
   public ResponseEntity<UserResponseDTO> getFullUserById(@PathVariable int id) {
    User user = userService.getUserById(id);
    UserResponseDTO userDTO = userMapper.toResponseDTO(user);
        return ResponseEntity.ok()
    .header("Authorization", "Bearer ")
    .body(userDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateUSer(
        @PathVariable int id, 
        @Valid   @RequestBody UserRequestDTO user){
        
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

@PostMapping("/login")
public ResponseEntity<UserResponseDTO> login(@RequestBody LoginRequestDTO credentials) {
    User user = userService.login(credentials);
    UserResponseDTO userDTO = userMapper.toResponseDTO(user);
    return new ResponseEntity<>(userDTO, HttpStatus.OK);
}

}