package com.jobboard.Job.Board.Apllicatins.api;

import com.jobboard.Job.Board.Apllicatins.dto.ApplicantDto;
import com.jobboard.Job.Board.Apllicatins.dto.JobDto;
import com.jobboard.Job.Board.Apllicatins.dto.ResponseDto;
import com.jobboard.Job.Board.Apllicatins.dto.UserDto;
import com.jobboard.Job.Board.Apllicatins.exception.JobPortalException;
import com.jobboard.Job.Board.Apllicatins.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static javax.security.auth.callback.ConfirmationCallback.OK;

@RestController
@CrossOrigin
@Validated
@RequestMapping("/jobs")
public class JobAPI {
    @Autowired
    private JobService jobService;

    @PostMapping("/post")
    public ResponseEntity<JobDto>postJob(@RequestBody JobDto jobDto)throws JobPortalException {

        return new ResponseEntity<>(jobService.postJob(jobDto), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<JobDto>> getAllJobs(@RequestBody JobDto jobDto)throws JobPortalException {

        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<JobDto> getJob(@PathVariable Long id )throws JobPortalException {

        return new ResponseEntity<>(jobService.getJob(id), HttpStatus.OK);

    }
    @PostMapping("/apply/{id}")
    public ResponseEntity<ResponseDto> applyJob(@PathVariable Long id, @RequestBody ApplicantDto applicantDto)throws JobPortalException {
        jobService.applyJob(id,applicantDto);
        return new ResponseEntity<>(new ResponseDto("Applied Successfully"),HttpStatus.OK);
    }
}
