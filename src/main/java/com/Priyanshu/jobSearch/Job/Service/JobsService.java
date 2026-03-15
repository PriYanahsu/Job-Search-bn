package com.Priyanshu.jobSearch.Job.Service;

import com.Priyanshu.jobSearch.Job.Model.JobModel;
import com.Priyanshu.jobSearch.Job.Repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

@Service
public class JobsService {

    @Autowired
    private JobRepo jobrepo;

    public JobModel addJob(JobModel job){
        return jobrepo.save(job);
    }
}
