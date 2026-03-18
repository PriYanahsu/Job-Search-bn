package com.Priyanshu.jobSearch.User.Service;

import com.Priyanshu.jobSearch.Config.SecurityConfig;
import com.Priyanshu.jobSearch.User.Model.Role;
import com.Priyanshu.jobSearch.User.Model.UserModel;
import com.Priyanshu.jobSearch.User.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(UserModel user){

        Optional<UserModel> existingUser = userRepository.findByEmail(user.getEmail());

        if(existingUser.isPresent()){
            return "EMAIL_ALREADY_EXISTS";
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        if(user.getEmail().equals("priyanshu@gmail.com")){
            user.setRole(Role.OWNER);
        } else {
            user.setRole(Role.USER);
        }

        userRepository.save(user);

        return "REGISTER_SUCCESS";
    }

    public Optional<UserModel> loginUser(String email, String password){

        Optional<UserModel> user = userRepository.findByEmail(email);

        return user.filter(u -> passwordEncoder.matches(password, u.getPassword()));
    }
}