package com.Priyanshu.jobSearch.Application.Controller;

import com.Priyanshu.jobSearch.Application.DTO.ApplyJobRequest;
import com.Priyanshu.jobSearch.Application.Service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationservice;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/apply")
    public String ApplyJob(@RequestBody ApplyJobRequest jobRequest){
        return applicationservice.JobApply(
                jobRequest.getUserId(),
                jobRequest.getJobId()
        );
    }
}
