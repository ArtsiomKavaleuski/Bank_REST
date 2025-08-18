package by.koval.bankcards.service;

import by.koval.bankcards.dto.CardMapper;
import by.koval.bankcards.dto.CardRequestDto;
import by.koval.bankcards.dto.CardResponseDto;
import by.koval.bankcards.entity.Card;
import by.koval.bankcards.entity.CardStatus;
import by.koval.bankcards.exception.NotFoundException;
import by.koval.bankcards.repository.CardsRepository;
import by.koval.bankcards.repository.UserRepository;
import by.koval.bankcards.util.CardUtil;
import by.koval.bankcards.util.EncryptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CardServiceImpl implements CardService {
    private final CardsRepository cardsRepository;
    private final EncryptionService encryptionService;
    private final UserRepository userRepository;

    @Override
    public List<CardResponseDto> getCards() {
        return cardsRepository.findAll().stream()
                .map(CardMapper::toCardDto)
                .toList();
    }

    @Override
    public List<CardResponseDto> getCardsByOwner(long id) {
        return cardsRepository.findCardsByOwnerId(id).stream()
                .map(CardMapper::toCardDto)
                .toList();
    }

    @Override
    public CardResponseDto getCard(long id) {
        return CardMapper.toCardDto(cardsRepository.findCardById(id).orElseThrow(() -> new NotFoundException("Карта не найдена")));
    }

    @Override
    public CardResponseDto createCard(CardRequestDto cardRequestDto) {
        Card card = new Card();
        card.setCardNumber(encryptionService.encrypt(CardUtil.generateCardNumber()));
        card.setStatus(CardStatus.ACTIVE);
        card.setOwner(userRepository.findUserById(cardRequestDto.getOwnerId()));
        card.setBalance(0.0);
        card.setExpiryDate(LocalDate.now().plusYears(3));
        return CardMapper.toCardDto(cardsRepository.save(card));
    }

    @Override
    public CardResponseDto updateCardStatus(long id, String status) {
        Card card = cardsRepository.findCardById(id).orElseThrow(() -> new NotFoundException("Карта не найдена"));
        card.setStatus(CardStatus.valueOf(status));
        return CardMapper.toCardDto(cardsRepository.save(card));
    }

    @Override
    public void deleteCard(long id) {
        cardsRepository.deleteById(id);
    }
}
