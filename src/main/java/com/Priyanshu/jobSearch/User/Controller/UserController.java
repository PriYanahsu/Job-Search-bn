package com.Priyanshu.jobSearch.User.Controller;

import com.Priyanshu.jobSearch.Config.JwtUtil;
import com.Priyanshu.jobSearch.User.Model.UserModel;
import com.Priyanshu.jobSearch.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<?> loginUser(@RequestBody UserModel user){

        boolean valid = userService.loginUser(user.getEmail(), user.getPassword());

        Map<String, Object> response = new HashMap<>();

        if(!valid){
            response.put("status","error");
            response.put("message","Invalid email or password");

            return ResponseEntity.status(401).body(response);
        }

        String accessToken = jwtUtil.generateAccessToken(user.getEmail());
        String refreshToken = jwtUtil.generateRefreshToken(user.getEmail());

        response.put("status","success");
        response.put("accessToken", accessToken);
        response.put("refreshToken", refreshToken);

        return ResponseEntity.ok(response);
    }

}