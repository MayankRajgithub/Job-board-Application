package com.jobboard.Job.Board.Apllicatins.service;

import com.jobboard.Job.Board.Apllicatins.dto.LoginDto;
import com.jobboard.Job.Board.Apllicatins.dto.UserDto;
import com.jobboard.Job.Board.Apllicatins.entity.User;
import com.jobboard.Job.Board.Apllicatins.exception.JobPortalException;
import com.jobboard.Job.Board.Apllicatins.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private UserRepository userRepository;

     @Override
    public UserDto registerUser(UserDto userDto) throws JobPortalException{
         Optional<User> optional=userRepository.findByEmail(userDto.getEmail());
        if(optional.isPresent())throw  new JobPortalException("USER_FOUND");
userDto.setProfileId(profileService.createProfile(userDto.getEmail()));
         userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
         User user = userDto.toEntity();
       user= userRepository.save(user);

        return user.toDto();
    }

    @Override
    public UserDto getUserByEmail(String email) throws JobPortalException {
        return userRepository.findByEmail(email).orElseThrow(() -> new
                JobPortalException("USER_NOT_FOUND")).toDto();
    }

    @Override
    public UserDto loginUser(LoginDto loginDto) throws JobPortalException {
        User user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow(()
                -> new JobPortalException("USER_NOT_FOUND"));
        if (!passwordEncoder.matches(loginDto.getPassword(),
                user.getPassword())) throw new
                JobPortalException("INVALID_CREDENTIALS");
        return user.toDto();
    }
}
