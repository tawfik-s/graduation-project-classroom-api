package com.tawfeek.quiz_api.controller;

import com.tawfeek.quiz_api.model.user.UserResponseDTO;
import com.tawfeek.quiz_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long id) {
        UserResponseDTO user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findUsersByName(@RequestParam String name) {
        List<UserResponseDTO> users = userService.findUsersByName(name);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/email")
    public ResponseEntity<UserResponseDTO> findUserByEmail(@RequestParam String email) {
        UserResponseDTO user = userService.findUserByEmail(email);
        return ResponseEntity.ok(user);
    }
}