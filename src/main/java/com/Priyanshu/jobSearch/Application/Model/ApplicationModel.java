package com.Priyanshu.jobSearch.Application.Model;

import com.Priyanshu.jobSearch.Job.Model.JobModel;
import com.Priyanshu.jobSearch.User.Model.UserModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JoinColumn(name = "userId")
    @JsonBackReference(value = "user-application")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "jobId")
    @JsonBackReference(value = "job-application")
    private JobModel job;

    private String status;

}
