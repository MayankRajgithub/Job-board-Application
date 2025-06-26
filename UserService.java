package com.jobboard.Job.Board.Apllicatins.service;

import com.jobboard.Job.Board.Apllicatins.dto.LoginDto;
import com.jobboard.Job.Board.Apllicatins.dto.UserDto;
import com.jobboard.Job.Board.Apllicatins.exception.JobPortalException;
import org.springframework.stereotype.Service;


public interface UserService {
    public UserDto registerUser(UserDto userDto) throws JobPortalException;
public UserDto getUserByEmail(String email) throws JobPortalException;
   public UserDto loginUser(LoginDto loginDto) throws JobPortalException;
}
