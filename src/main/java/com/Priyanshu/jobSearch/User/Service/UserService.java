package com.Priyanshu.jobSearch.User.Service;

import com.Priyanshu.jobSearch.User.Model.UserModel;
import com.Priyanshu.jobSearch.User.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    public String registerUser(UserModel user){

        Optional<UserModel> existingUser = userRepository.findByEmail(user.getEmail());

        if(existingUser.isPresent()){
            return "EMAIL_ALREADY_EXISTS";
        }

        userRepository.save(user);

        return "REGISTER_SUCCESS";
    }

    public boolean loginUser(String email, String password){

        Optional<UserModel> user = userRepository.findByEmail(email);

        if(user.isEmpty()){
            return false;
        }

        return user.get().getPassword().equals(password);
    }

}