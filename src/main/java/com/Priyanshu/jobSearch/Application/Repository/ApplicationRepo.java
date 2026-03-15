package com.Priyanshu.jobSearch.Application.Repository;

import com.Priyanshu.jobSearch.Application.Model.ApplicationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepo extends JpaRepository <ApplicationModel, Long> {

}
