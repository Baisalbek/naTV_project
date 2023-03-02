package kg.mega.naTV.repository;

import kg.mega.naTV.entities.Discounts;
import kg.mega.naTV.entities.dto.DiscountDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRepo extends JpaRepository<Discounts, Long> {
    List<Discounts> findAllByChannelId(Long id);
}
