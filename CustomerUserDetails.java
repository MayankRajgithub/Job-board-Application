package com.jobboard.Job.Board.Apllicatins.jwt;

import com.jobboard.Job.Board.Apllicatins.dto.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUserDetails implements UserDetails {
   private Long id;
   private String username;
   private String password;
   private AccountType accountType;
   private Collection<?extends GrantedAuthority>authorities;


}
