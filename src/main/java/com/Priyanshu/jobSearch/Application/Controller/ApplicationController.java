package com.Priyanshu.jobSearch.Application.Controller;

import com.Priyanshu.jobSearch.Application.DTO.ApplyJobRequest;
import com.Priyanshu.jobSearch.Application.Service.ApplicationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {

    private ApplicationService applicationservice;

    @PostMapping("/apply")
    public String ApplyJob(ApplyJobRequest jobRequest){
        return applicationservice.JobApply(
                jobRequest.getUserId(),
                jobRequest.getUserId()
        );
    }
}
