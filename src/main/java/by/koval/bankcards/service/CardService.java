package by.koval.bankcards.service;

import by.koval.bankcards.dto.CardRequestDto;
import by.koval.bankcards.dto.CardResponseDto;

import java.util.List;

public interface CardService {
    List<CardResponseDto> getCards();
    List<CardResponseDto> getCardsByOwner(long id);
    CardResponseDto getCard(long id);
    CardResponseDto createCard(CardRequestDto cardRequestDto);
    CardResponseDto updateCardStatus(long id, String status);
    void deleteCard(long id);
}
