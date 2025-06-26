package com.jobboard.Job.Board.Apllicatins.service;

import com.jobboard.Job.Board.Apllicatins.dto.ProfileDto;
import com.jobboard.Job.Board.Apllicatins.entity.Profile;
import com.jobboard.Job.Board.Apllicatins.exception.JobPortalException;
import com.jobboard.Job.Board.Apllicatins.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.Utilities;
import java.util.ArrayList;

@Service("profileService")
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Long createProfile(String email) {
       Profile profile = new Profile();
       profile.setEmail(email);
       profile.setSkills(new ArrayList<>());
       profile.setExperiences(new ArrayList<>());
       profile.setCertifications(new ArrayList<>());
       profileRepository.save(profile);
       return profile.getId();

    }

    @Override
    public ProfileDto getProfile(Long id) throws JobPortalException {
        return profileRepository.findById(id).orElseThrow(()->new JobPortalException("PROFILE_NOT_FOUND")).toDto();
    }

    @Override
    public ProfileDto updateProfile(ProfileDto profileDto) throws JobPortalException {
        profileRepository.findById(profileDto.getId()).orElseThrow(()->new JobPortalException("PROFILE_NOT_FOUND"));
  profileRepository.save(profileDto.toEntity());
  return profileDto;
    }
}
