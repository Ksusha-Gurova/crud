package ru.neoflex.crud.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String fullname;
    private String email;
    private String phone;
    private String address;
    private LocalDate dateOfBirth;
}
