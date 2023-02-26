package kg.mega.naTV.repository;

import kg.mega.naTV.entities.OrderDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDateRepo extends JpaRepository<OrderDate, Long> {
}
