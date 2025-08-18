package by.koval.bankcards.dto;

import by.koval.bankcards.entity.Card;
import by.koval.bankcards.util.CardUtil;
import by.koval.bankcards.util.EncryptionService;

public class CardMapper {
    private static EncryptionService encryptionService;

//   static {
//       try {
//           ApplicationContext context = new ApplicationConfigApplicationContext()
//       }
//       catch (Exception e) {
//           throw new RuntimeException("Can't initialize encryption service");
//       }
//   }

    public static CardResponseDto toCardDto(Card card) {
        CardResponseDto cardResponseDto = new CardResponseDto();
        cardResponseDto.setId(card.getId());
        cardResponseDto.setMaskedCardNumber(CardUtil.maskCardNumber(encryptionService.decrypt(card.getCardNumber())));
        cardResponseDto.setStatus(card.getStatus());
        cardResponseDto.setOwner(UserMapper.toUserResponseDto(card.getOwner()));
        cardResponseDto.setExpiryDate(card.getExpiryDate());
        return cardResponseDto;
    }
}
