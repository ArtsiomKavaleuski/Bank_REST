package by.koval.bankcards.controller;

import by.koval.bankcards.dto.CardResponseDto;
import by.koval.bankcards.service.CardService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class CardController {
    private final CardService cardService;

    @GetMapping("/admin/cards")
    @PreAuthorize("hasRole('ADMIN')")
    public List<CardResponseDto> getCards() {
        return cardService.getCards();
    }

    @GetMapping("/cards")
    @PreAuthorize("hasRole('USER')")
    public List<CardResponseDto> getCardsByUser(@RequestBody HttpServletRequest request) {
        return List.of();
    }
}
