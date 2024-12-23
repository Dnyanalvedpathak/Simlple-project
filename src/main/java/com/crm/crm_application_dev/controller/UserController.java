package com.crm.crm_application_dev.controller;

import com.crm.crm_application_dev.entity.SignInRequest;
import com.crm.crm_application_dev.entity.SignInResponse;
import com.crm.crm_application_dev.entity.User;
import com.crm.crm_application_dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody User user) {
        if (userService.getUserByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already exists");
        }
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/signin")
    public ResponseEntity<SignInResponse> signIn(@RequestBody SignInRequest signInRequest){
        User user = userService.getUserByEmail(signInRequest.getEmail())
                .orElse(null);

        System.out.println(user);

        if(user != null && user.getPassword().equals(signInRequest.getPassword())){
            return ResponseEntity.ok(new SignInResponse(1, "Login Successful"));
        }else {
            return ResponseEntity.ok(new SignInResponse(0,"Login Unsuccessful"));
        }


    }





}
