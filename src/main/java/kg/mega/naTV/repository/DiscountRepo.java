package kg.mega.naTV.repository;

import kg.mega.naTV.entities.Discounts;
import kg.mega.naTV.entities.dto.DiscountDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRepo extends JpaRepository<Discounts, Long> {
    @Query(value = "select * from discounts where channel_id = :id order by from_day_count",nativeQuery = true)
    List<Discounts> findAllByChannelId(Long id);

    Discounts findByChannelId(Long id);
}
