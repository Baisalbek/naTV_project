package kg.mega.naTV.repository;

import kg.mega.naTV.entities.Channels;
import kg.mega.naTV.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.channels.Channel;

@Repository
public interface ChannelRepo extends JpaRepository<Channels, Long> {
    Channels findByNameOfChannel(String nameOfChannel);
}
