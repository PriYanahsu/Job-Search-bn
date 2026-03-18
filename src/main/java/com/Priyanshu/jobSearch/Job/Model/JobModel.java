package com.Priyanshu.jobSearch.Job.Model;

import com.Priyanshu.jobSearch.Application.Model.ApplicationModel;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Jobs")
@Getter
@Setter
public class JobModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String jobTittle;

    private String description;

    List<String> skillsRequired;

    @OneToMany(mappedBy = "job")
    @JsonManagedReference
    List<ApplicationModel> applications;
}
