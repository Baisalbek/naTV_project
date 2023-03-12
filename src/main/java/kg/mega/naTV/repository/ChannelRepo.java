package kg.mega.naTV.repository;

import kg.mega.naTV.entities.Channels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepo extends JpaRepository<Channels, Long> {
    Channels findByChannelName(String channelName);
}
