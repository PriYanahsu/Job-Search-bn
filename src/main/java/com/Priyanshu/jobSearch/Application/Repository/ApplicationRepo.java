package com.Priyanshu.jobSearch.Application.Repository;

import com.Priyanshu.jobSearch.Application.Model.ApplicationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationRepo extends JpaRepository <ApplicationModel, Long> {

    // Spring Data JPA will auto-implement this query
    boolean existsByUserIdAndJobId(Long userId, Long jobId);

}
