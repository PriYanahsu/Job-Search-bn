package com.Priyanshu.jobSearch.Job.Repository;

import com.Priyanshu.jobSearch.Application.Model.ApplicationModel;
import com.Priyanshu.jobSearch.Job.DTO.AppliedJobDTO;
import com.Priyanshu.jobSearch.Job.Model.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobModel, Long> {

    @Query("SELECT new com.Priyanshu.jobSearch.Job.DTO.AppliedJobDTO(a.job.id) FROM ApplicationModel a WHERE a.user.id = :userId")
    List<AppliedJobDTO> getAllJobUser(@Param("userId") long userId);

}
