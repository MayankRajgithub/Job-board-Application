package com.jobboard.Job.Board.Apllicatins.service;

import com.jobboard.Job.Board.Apllicatins.dto.Applicant;
import com.jobboard.Job.Board.Apllicatins.dto.ApplicantDto;
import com.jobboard.Job.Board.Apllicatins.dto.ApplicationStatus;
import com.jobboard.Job.Board.Apllicatins.dto.JobDto;
import com.jobboard.Job.Board.Apllicatins.entity.Job;
import com.jobboard.Job.Board.Apllicatins.exception.JobPortalException;
import com.jobboard.Job.Board.Apllicatins.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.Utilities;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class JobServiceImpl implements JobService{
    @Autowired
    private JobRepository jobRepository;

    @Override
    public JobDto postJob(JobDto jobDto) {
        jobDto.setPostTime(LocalDateTime.now());
        return jobRepository.save(jobDto.toEntity()).toDto();
    }

    @Override
    public List<JobDto> getAllJobs() {
        return jobRepository.findAll().stream()
                .map(Job::toDto)
                .collect(toList());

    }

    @Override
    public JobDto getJob(Long id) throws JobPortalException {
        return jobRepository.findById(id).orElseThrow(()->new JobPortalException("JOB_NOT_FOUND")).toDto();
    }

    @Override
    public void applyJob(Long id, ApplicantDto applicantDto) throws JobPortalException {
     Job job = jobRepository.findById(id).orElseThrow(()->new JobPortalException("JOB_NOT_FOUND"));
List<Applicant>applicants=job.getApplicants();
if (applicants==null)applicants=new ArrayList<>();
if (applicants.stream().filter((x)->x.getApplicantId()==applicantDto.
        getApplicantId()).toList().size()>0)throw new
                JobPortalException("JOB_APPLIED_ALREADY");
applicantDto.setApplicationStatus(ApplicationStatus.APPLIED);
applicants.add(applicantDto.toEntity());
job.setApplicants(applicants);
jobRepository.save(job);

    }
}
