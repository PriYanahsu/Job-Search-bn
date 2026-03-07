package com.Priyanshu.jobSearch.User.Repository;

import com.Priyanshu.jobSearch.User.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByEmail(String email);

}