package kg.mega.naTV.repository;

import kg.mega.naTV.entities.OrderedChannels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedChannelsRepo extends JpaRepository<OrderedChannels, Long> {
}
