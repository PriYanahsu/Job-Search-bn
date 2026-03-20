package com.Priyanshu.jobSearch.Job.Controller;

import com.Priyanshu.jobSearch.Application.Model.ApplicationModel;
import com.Priyanshu.jobSearch.Job.DTO.AppliedJobDTO;
import com.Priyanshu.jobSearch.Job.Model.JobModel;
import com.Priyanshu.jobSearch.Job.Repository.JobRepo;
import com.Priyanshu.jobSearch.Job.Service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    public JobsService jobservice;

    @PreAuthorize("hasRole('OWNER')")
    @PostMapping("/addJob")
    public ResponseEntity<?> addJobs(@RequestBody JobModel job){

        System.out.println("What is the issue"+ job);

        Map<String, Object> response = new HashMap<>();

        JobModel savedJob = jobservice.addJob(job);
        if(savedJob != null){
            response.put("status", "Success");
            response.put("message", "Successfully added the job");

            return ResponseEntity.ok(response);
        }

        response.put("status", "error");
        response.put("message", "Not able to upload job");
        return ResponseEntity.badRequest().body(response);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/applied/{userId}")
    public List<AppliedJobDTO> getAllJobs(@PathVariable Long userId){
        List<AppliedJobDTO> jobs = jobservice.getAllJobsUser(userId);

        System.out.println("Jobs fetched: " + jobs);

        return jobs;
    }


    @GetMapping("/getAllJobs")
    public List<JobModel> getAllJobs(){
        return jobservice.getAllJobs();
    }
}
