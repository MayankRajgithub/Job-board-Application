package com.jobboard.Job.Board.Apllicatins.entity;

import com.jobboard.Job.Board.Apllicatins.dto.Applicant;
import com.jobboard.Job.Board.Apllicatins.dto.ApplicantDto;
import com.jobboard.Job.Board.Apllicatins.dto.JobDto;
import com.jobboard.Job.Board.Apllicatins.dto.JobStatus;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobTitle;
    private String company;
    private List<Applicant> applicants;
    private String about;
    private String experience;
    private String jobType;
    private String location;
    private Long packageOffered;
    private LocalDateTime postTime;
    private String description;
    private List<String>skillsRequired;
    private JobStatus jobStatus;

    public JobDto toDto(){
        return new JobDto(this.id,this.jobTitle,this.company,this.applicants != null
                ? this.applicants.stream()
                .map(Applicant::toDto)
                .collect(Collectors.toList())
                : null,this.about,this.experience,this.jobType,this.location,this.packageOffered,this.postTime,this.description,this.skillsRequired,this.jobStatus);
    }
}
