package by.koval.bankcards.repository;

import by.koval.bankcards.entity.Card;
import by.koval.bankcards.entity.CardStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardsRepository extends JpaRepository<Card, Long> {
    List<Card> findByCardNumber(String cardNumber);
    List<Card> findByStatus(CardStatus status);
    List<Card> findByOwner_username(String username);
}
