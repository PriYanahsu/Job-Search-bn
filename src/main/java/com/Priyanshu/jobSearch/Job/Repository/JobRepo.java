package com.Priyanshu.jobSearch.Job.Repository;

import com.Priyanshu.jobSearch.Job.Model.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<JobModel, Long> {
}
