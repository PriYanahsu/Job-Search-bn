package com.Priyanshu.jobSearch.Job.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppliedJobDTO {
    private Long jobId;

    public AppliedJobDTO(Long jobId) {
        this.jobId = jobId;
    }
}
