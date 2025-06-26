package com.jobboard.Job.Board.Apllicatins.entity;

import com.jobboard.Job.Board.Apllicatins.dto.AccountType;
import com.jobboard.Job.Board.Apllicatins.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private Long profileId;


    public UserDto toDto() {
        return new UserDto(this.id, this.name, this.email, this.password, this.accountType,this.profileId);
    }
}