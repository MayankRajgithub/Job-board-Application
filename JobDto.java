package com.jobboard.Job.Board.Apllicatins.dto;

import com.jobboard.Job.Board.Apllicatins.entity.Job;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {
    private Long id;
    private String jobTitle;
    private String company;
    private List<ApplicantDto> applicants;
    private String about;
    private String experience;
    private String jobType;
    private String location;
    private Long packageOffered;
    private LocalDateTime postTime;
    private String description;
    private List<String>skillsRequired;
    private JobStatus jobStatus;


    public Job toEntity(){
        return new Job(this.id,this.jobTitle,this.company,this.applicants != null
                ? this.applicants.stream()
                .map(ApplicantDto::toEntity)
                .collect(Collectors.toList())
                : null ,this.about,this.experience,this.jobType,this.location,this.packageOffered,this.postTime,this.description,this.skillsRequired,this.jobStatus);
    }
}
