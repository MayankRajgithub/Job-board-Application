package com.jobboard.Job.Board.Apllicatins.dto;

import com.jobboard.Job.Board.Apllicatins.entity.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Base64;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto {
    private Long id;
    private String email;
    private String jobTitle;
    private String company;
    private String location;
    private String about;
    private String picture;
    private List<String> skills;
    private List<Experience> experiences;
    private List<Certification> certifications;
    private List<Long>savedJobs;

    public Profile toEntity() {
        return new Profile(this.id, this.email, this.jobTitle, this.company, this.location, this.about, this.picture != null ? String.valueOf(Base64.getDecoder().decode(this.picture)) : null, this.skills, this.experiences, this.certifications, this.savedJobs);
    }

    }
