package com.Priyanshu.jobSearch.Job.Controller;

import com.Priyanshu.jobSearch.Job.Model.JobModel;
import com.Priyanshu.jobSearch.Job.Service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    public JobsService jobservice;

    @PostMapping("/addJobs")
    public ResponseEntity<?> addJobs(JobModel job){

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
}
