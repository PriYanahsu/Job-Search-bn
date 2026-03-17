package com.Priyanshu.jobSearch.Application.Service;

import com.Priyanshu.jobSearch.Application.Model.ApplicationModel;
import com.Priyanshu.jobSearch.Application.Repository.ApplicationRepo;
import com.Priyanshu.jobSearch.Job.Model.JobModel;
import com.Priyanshu.jobSearch.Job.Repository.JobRepo;
import com.Priyanshu.jobSearch.User.Model.UserModel;
import com.Priyanshu.jobSearch.User.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    @Autowired
    private JobRepo jobrepo;

    @Autowired
    private UserRepo userrepo;

    @Autowired
    private ApplicationRepo applicationrepo;

    public String JobApply(Long UserId, Long JobId){

        UserModel user = userrepo.findById(UserId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        JobModel Job = jobrepo.findById(JobId)
                .orElseThrow(() -> new RuntimeException("Job Not Found"));

        ApplicationModel application = new ApplicationModel();

        application.setJob(Job);
        application.setUser(user);
        application.setStatus("Applied");

        applicationrepo.save(application);
        return "Application Successfully applied";
    }
}
