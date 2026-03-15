package com.Priyanshu.jobSearch.Job.Model;

import com.Priyanshu.jobSearch.Application.Model.ApplicationModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Jobs")
public class JobModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String jobTittle;

    private String description;

    List<String> skillsRequired;

    @OneToMany(mappedBy = "job")
    List<ApplicationModel> applications;
}
