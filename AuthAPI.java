package com.jobboard.Job.Board.Apllicatins.api;

import com.jobboard.Job.Board.Apllicatins.jwt.AuthenticationRequest;
import com.jobboard.Job.Board.Apllicatins.jwt.AuthenticationResponse;
import com.jobboard.Job.Board.Apllicatins.jwt.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthAPI {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?>createAuthenticationToken(@RequestBody AuthenticationRequest request){
        authenticationManager.authenticate(new
                UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
   final UserDetails userDetails=userDetailsService.loadUserByUsername(request.getEmail());
   final String jwt= JwtHelper.generateToken(userDetails);
   return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
