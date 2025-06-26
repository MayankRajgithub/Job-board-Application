package com.jobboard.Job.Board.Apllicatins.dto;

import com.jobboard.Job.Board.Apllicatins.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.processing.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    @NotBLank(message="{user.name.absent}")
    private String name;
    @NotBLank(message = "{user.email.absent}")
    @Email(message ="{user.email.invalid}"  )
    private String email;
    @NotBLank(message = "{user.password.absent}")
    private String password;
    private AccountType accountType;
    private Long profileId;

    public User toEntity() {
        return new User(this.id, this.name, this.email, this.password, this.accountType,this.profileId);
    }
}