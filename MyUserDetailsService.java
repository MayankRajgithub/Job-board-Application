package com.jobboard.Job.Board.Apllicatins.jwt;

import com.jobboard.Job.Board.Apllicatins.dto.UserDto;
import com.jobboard.Job.Board.Apllicatins.exception.JobPortalException;
import com.jobboard.Job.Board.Apllicatins.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
   @Autowired
   private UserService userService;
    private String email;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       try {
           UserDto dto = userService.getUserByEmail(email);
       return new CustomerUserDetails(dto.getId(),email, dto.getPassword(),dto.getAccountType(),new ArrayList<>());
       }
       catch (JobPortalException e){
           e.printStackTrace();
       }
        return null;
    }
}
