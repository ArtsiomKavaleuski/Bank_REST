package by.koval.bankcards.service;

import by.koval.bankcards.dto.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}
