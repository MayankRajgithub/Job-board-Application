package com.jobboard.Job.Board.Apllicatins.service;

import com.jobboard.Job.Board.Apllicatins.dto.ApplicantDto;
import com.jobboard.Job.Board.Apllicatins.dto.JobDto;
import com.jobboard.Job.Board.Apllicatins.exception.JobPortalException;

import java.util.List;

public interface JobService {

  public JobDto  postJob(JobDto jobDto) throws JobPortalException;

  public List<JobDto> getAllJobs();

  public JobDto getJob(Long id) throws JobPortalException;

    public void applyJob(Long id, ApplicantDto applicantDto)throws JobPortalException;
}
