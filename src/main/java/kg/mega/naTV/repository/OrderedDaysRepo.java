package kg.mega.naTV.repository;

import kg.mega.naTV.entities.OrderedDays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedDaysRepo extends JpaRepository<OrderedDays, Long> {
}
