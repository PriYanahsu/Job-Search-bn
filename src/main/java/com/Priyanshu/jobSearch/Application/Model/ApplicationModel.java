package com.Priyanshu.jobSearch.Application.Model;

import com.Priyanshu.jobSearch.Job.Model.JobModel;
import com.Priyanshu.jobSearch.User.Model.UserModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Application")
@Getter
@Setter
public class ApplicationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "job_Id")
    private JobModel job;

    private String status;

}
