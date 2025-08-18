package by.koval.bankcards.repository;

import by.koval.bankcards.entity.Card;
import by.koval.bankcards.entity.CardStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardsRepository extends JpaRepository<Card, Long> {
    List<Card> findCardsByOwnerId(Long ownerId);
    Optional<Card> findCardById(Long id);
}
