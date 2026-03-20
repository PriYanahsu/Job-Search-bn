package com.Priyanshu.jobSearch.User.Controller;

import com.Priyanshu.jobSearch.Config.JwtUtil;
import com.Priyanshu.jobSearch.User.DTO.UserLoginDTO;
import com.Priyanshu.jobSearch.User.Model.UserModel;
import com.Priyanshu.jobSearch.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserModel user){

        String result = userService.registerUser(user);

        Map<String, Object> response = new HashMap<>();

        if(result.equals("EMAIL_ALREADY_EXISTS")){
            response.put("status","error");
            response.put("message","Email already exists");

            return ResponseEntity.badRequest().body(response);
        }

        response.put("status","success");
        response.put("message","User registered successfully");

        return ResponseEntity.ok(response);
    }


    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDTO user){

        Optional<UserModel> validUser =
                userService.loginUser(user.getEmail(), user.getPassword());

        Map<String, Object> response = new HashMap<>();

        if(validUser.isEmpty()){
            response.put("status","error");
            response.put("message","Invalid email or password");
            return ResponseEntity.status(401).body(response);
        }

        UserModel loggedInUser = validUser.get();

        // Include ROLE in token
        String accessToken = jwtUtil.generateAccessToken(
                loggedInUser.getEmail(),
                loggedInUser.getRole().name()
        );

        String refreshToken = jwtUtil.generateRefreshToken(loggedInUser.getEmail());

        response.put("status","success");
        response.put("accessToken", accessToken);
        response.put("refreshToken", refreshToken);

        // Send extra info (useful for frontend)
        response.put("role", loggedInUser.getRole());
        response.put("userId", loggedInUser.getId());

        return ResponseEntity.ok(response);
    }

}