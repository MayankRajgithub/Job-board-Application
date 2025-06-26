package com.jobboard.Job.Board.Apllicatins.api;

import com.jobboard.Job.Board.Apllicatins.dto.ProfileDto;
import com.jobboard.Job.Board.Apllicatins.exception.JobPortalException;
import com.jobboard.Job.Board.Apllicatins.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Validated
@RequestMapping("/users")
public class ProfileAPI {
    @Autowired
    private ProfileService profileService;

    @GetMapping("/get/{id}")
    public ResponseEntity<ProfileDto>getProfile(@PathVariable Long id) throws JobPortalException{
        return new ResponseEntity<>(profileService.getProfile(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ProfileDto>updateProfile(@RequestBody ProfileDto profileDto) throws JobPortalException{
        return new ResponseEntity<>(profileService.updateProfile(profileDto), HttpStatus.OK);
    }


}
