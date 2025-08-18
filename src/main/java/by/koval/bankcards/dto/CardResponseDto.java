package by.koval.bankcards.dto;

import by.koval.bankcards.entity.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardResponseDto {
    private Long id;
    private String maskedCardNumber;
    private LocalDate expiryDate;
    private CardStatus status;
    private UserResponseDto owner;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        CardResponseDto that = (CardResponseDto) o;
        return Objects.equals(id, that.id) && Objects.equals(maskedCardNumber, that.maskedCardNumber) && Objects.equals(expiryDate, that.expiryDate) && status == that.status && Objects.equals(owner, that.owner);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(maskedCardNumber);
        result = 31 * result + Objects.hashCode(expiryDate);
        result = 31 * result + Objects.hashCode(status);
        result = 31 * result + Objects.hashCode(owner);
        return result;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", maskedCardNumber='" + maskedCardNumber + '\'' +
                ", expiryDate=" + expiryDate +
                ", status=" + status +
                ", owner=" + owner +
                '}';
    }
}
