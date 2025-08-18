package by.koval.bankcards.service;

import by.koval.bankcards.dto.UserMapper;
import by.koval.bankcards.dto.UserRequestDto;
import by.koval.bankcards.dto.UserResponseDto;
import by.koval.bankcards.entity.User;
import by.koval.bankcards.repository.RoleRepository;
import by.koval.bankcards.repository.UserRepository;
import by.koval.bankcards.util.EncryptionService;
import by.koval.bankcards.util.PasswordGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final EncryptionService encryptionService;
    private final RoleRepository roleRepository;

    @Override
    public List<UserResponseDto> getUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::toUserResponseDto)
                .toList();
    }

    @Override
    public UserResponseDto getUser(long id) {
        return UserMapper.toUserResponseDto(userRepository.getReferenceById(id));
    }

    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        User user = new User();
        user.setPassword(encryptionService.encrypt(PasswordGenerator.generatePassword(8)));
        user.setCreatedAt(LocalDateTime.now());
        user.setUsername(userRequestDto.getUsername());
        for (String roleId: userRequestDto.getRoleIds()) {
            user.getRoles().add(roleRepository.findById(Long.parseLong(roleId)));
        }
        return UserMapper.toUserResponseDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
