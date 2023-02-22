package kg.mega.naTV.repository;

import kg.mega.naTV.entities.Discount;
import kg.mega.naTV.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepo extends JpaRepository<Discount, Long> {
}
