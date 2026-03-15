package com.Priyanshu.jobSearch.User.Model;

import com.Priyanshu.jobSearch.Application.Model.ApplicationModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserModel {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    @Column(unique = true)
    private String email;

    private String password;

    @OneToMany(mappedBy = "user")
    List<ApplicationModel> applicationData;

}