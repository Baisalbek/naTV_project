package kg.mega.naTV.repository;

import kg.mega.naTV.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    @Query(value = "select * from tb_order where client_phone= :clientPhone", nativeQuery = true)
    Order findAllByClientPhone(String clientPhone);
}
