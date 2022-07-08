package ru.neoflex.crud.mapper;

import org.springframework.stereotype.Component;
import ru.neoflex.crud.api.dto.UserRequestDto;
import ru.neoflex.crud.api.dto.UserResponseDto;
import ru.neoflex.crud.entity.User;

@Component
public class UserMapperImpl implements UserMapper{

    @Override
    public UserResponseDto mapEntityToDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .fullname(user.getFullname())
                .email(user.getEmail())
                .phone(user.getPhone())
                .address(user.getAddress())
                .dateOfBirth(user.getDateOfBirth())
                .build();
    }

    @Override
    public User mapDtoToEntity(UserRequestDto dto) {
        return User.builder()
                .id(dto.getId())
                .fullname(dto.getFullname())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .address(dto.getAddress())
                .dateOfBirth(dto.getDateOfBirth())
                .build();
    }
}
