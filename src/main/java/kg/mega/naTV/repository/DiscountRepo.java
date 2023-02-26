package kg.mega.naTV.repository;

import kg.mega.naTV.entities.Discounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepo extends JpaRepository<Discounts, Long> {
}
