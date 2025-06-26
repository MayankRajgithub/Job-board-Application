package com.jobboard.Job.Board.Apllicatins.api;

import com.jobboard.Job.Board.Apllicatins.dto.LoginDto;
import com.jobboard.Job.Board.Apllicatins.dto.UserDto;
import com.jobboard.Job.Board.Apllicatins.exception.JobPortalException;
import com.jobboard.Job.Board.Apllicatins.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserAPI {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto>registerUser(@RequestBody UserDto userDto)throws JobPortalException {
    userDto=userService.registerUser(userDto);
    return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<UserDto>loginUser(@RequestBody LoginDto loginDto)throws JobPortalException{

        return new ResponseEntity<>(userService.loginUser(loginDto), HttpStatus.OK);
    }
}
