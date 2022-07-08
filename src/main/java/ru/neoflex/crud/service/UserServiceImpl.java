package ru.neoflex.crud.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.neoflex.crud.api.dto.UserRequestDto;
import ru.neoflex.crud.api.dto.UserResponseDto;
import ru.neoflex.crud.entity.User;
import ru.neoflex.crud.mapper.UserMapper;
import ru.neoflex.crud.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public List<UserResponseDto> findAll() {
        return repository.findAll().stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }

    @Override
    public UserResponseDto findUser(Long id) {
        return mapper.mapEntityToDto(repository.findById(id).get());
    }

    @Override
    public UserResponseDto saveOrUpdateUser(UserRequestDto dto) {
        User user = mapper.mapDtoToEntity(dto);
        return mapper.mapEntityToDto(repository.save(user));
    }



    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
