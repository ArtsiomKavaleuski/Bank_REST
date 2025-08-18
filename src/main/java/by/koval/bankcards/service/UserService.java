package by.koval.bankcards.service;

import by.koval.bankcards.dto.UserRequestDto;
import by.koval.bankcards.dto.UserResponseDto;
import by.koval.bankcards.entity.User;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getUsers();
    UserResponseDto getUser(long id);
    UserResponseDto addUser(UserRequestDto userRequestDto);
    void deleteUser(long id);
}
