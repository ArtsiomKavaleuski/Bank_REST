package by.koval.bankcards.dto;

import by.koval.bankcards.entity.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardRequestDto {
    private CardStatus status;
    private Long ownerId;
}
