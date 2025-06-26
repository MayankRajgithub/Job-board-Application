package com.jobboard.Job.Board.Apllicatins.entity;

import com.jobboard.Job.Board.Apllicatins.dto.Certification;
import com.jobboard.Job.Board.Apllicatins.dto.Experience;
import com.jobboard.Job.Board.Apllicatins.dto.ProfileDto;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Base64;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Profile {
    @Id
    private Long id;
    private String email;
    private String jobTitle;
    private String company;
    private String location;
    private byte[] picture;
    private String about;
    private List<String>skills;
    private List<Experience>experiences;
    private List<Certification>certifications;
    private List<Long>savedJobs;

    public Profile(Long id, String email, String jobTitle, String company, String location, String about, String about1, List<String> skills, List<Experience> experiences, List<Certification> certifications) {
    }

    public Profile(Long id, String email, String jobTitle, String company, String location, String about, String about1, List<String> skills, List<Experience> experiences, List<Certification> certifications, List<Long> savedJobs) {
    }

    public ProfileDto toDto(){
        return new ProfileDto(this.id,this.email,this.jobTitle,this.company,this.location,this.about,this.picture!=null?Base64.getEncoder().encodeToString(this.picture):null,this.skills,this.experiences,this.certifications,this.savedJobs);
    }
}
