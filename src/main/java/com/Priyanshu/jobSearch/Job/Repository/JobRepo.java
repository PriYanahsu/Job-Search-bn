package com.Priyanshu.jobSearch.Job.Repository;

import com.Priyanshu.jobSearch.Application.Model.ApplicationModel;
import com.Priyanshu.jobSearch.Job.Model.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobModel, Long> {

    @Query("Select a from ApplicationModel a where a.user.id = :userId")
    List<ApplicationModel> getAllJobUser(@Param("userId") long userId);


}
