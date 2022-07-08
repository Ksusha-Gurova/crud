package ru.neoflex.crud.service;

import ru.neoflex.crud.api.dto.UserRequestDto;
import ru.neoflex.crud.api.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> findAll();

    UserResponseDto findUser(Long id);

    UserResponseDto saveOrUpdateUser(UserRequestDto dto);

    void deleteUser(Long id);
}
