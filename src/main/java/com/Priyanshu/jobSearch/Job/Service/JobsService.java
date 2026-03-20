package com.Priyanshu.jobSearch.Job.Service;

import com.Priyanshu.jobSearch.Application.Model.ApplicationModel;
import com.Priyanshu.jobSearch.Job.DTO.AppliedJobDTO;
import com.Priyanshu.jobSearch.Job.Model.JobModel;
import com.Priyanshu.jobSearch.Job.Repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobsService {

    @Autowired
    private JobRepo jobrepo;

    public JobModel addJob(JobModel job){
        return jobrepo.save(job);
    }

    public List<AppliedJobDTO> getAllJobsUser(long userId){
        return jobrepo.getAllJobUser(userId);
    }

    public List<JobModel> getAllJobs(){
        return jobrepo.findAll();
    }

}
