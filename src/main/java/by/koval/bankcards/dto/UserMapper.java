package by.koval.bankcards.dto;

import by.koval.bankcards.entity.User;

public class UserMapper {
    public static UserResponseDto toUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setUsername(user.getUsername());
        userResponseDto.setRoles(user.getRoles());
        userResponseDto.setCreatedAt(user.getCreatedAt());
        return userResponseDto;
    }
}
