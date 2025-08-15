package by.koval.bankcards.repository;

import by.koval.bankcards.entity.BlockRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockRequestsRepository extends JpaRepository<BlockRequest, Long> {
    List<BlockRequest> findByCard_Owner_Username(String username);
}
