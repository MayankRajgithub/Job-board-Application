package com.jobboard.Job.Board.Apllicatins.service;

import com.jobboard.Job.Board.Apllicatins.dto.ProfileDto;
import com.jobboard.Job.Board.Apllicatins.exception.JobPortalException;

public interface ProfileService {
    public Long createProfile(String email);
    public ProfileDto getProfile(Long id)throws JobPortalException;
    public ProfileDto updateProfile( ProfileDto profileDto) throws JobPortalException;


}
