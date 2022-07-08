package ru.neoflex.crud.mapper;

import ru.neoflex.crud.api.dto.UserRequestDto;
import ru.neoflex.crud.api.dto.UserResponseDto;
import ru.neoflex.crud.entity.User;

public interface UserMapper {

    UserResponseDto mapEntityToDto(User user);

    User mapDtoToEntity(UserRequestDto dto);
}
