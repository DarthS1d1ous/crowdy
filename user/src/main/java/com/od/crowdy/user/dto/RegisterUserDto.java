package com.od.crowdy.user.dto;

import com.od.crowdy.user.domain.neo4j.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDto extends UserDto {
    private String password;

    public static User toModel(RegisterUserDto registerUserDto) {
        return User.builder()
            .username(registerUserDto.getUsername())
            .password(registerUserDto.getPassword())
            .birthday(registerUserDto.getBirthday())
            .avatar(registerUserDto.getAvatar())
            .fullName(registerUserDto.getFullName())
            .createdAt(LocalDate.now())
            .build();
    }
}
