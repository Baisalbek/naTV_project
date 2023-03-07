package kg.mega.naTV.repository;

import kg.mega.naTV.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriceRepo extends JpaRepository<Price, Long> {
    Price findByChannelsId(Long id);
}
