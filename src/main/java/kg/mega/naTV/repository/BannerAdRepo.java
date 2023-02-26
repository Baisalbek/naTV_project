package kg.mega.naTV.repository;

import kg.mega.naTV.entities.BannerAd;
import kg.mega.naTV.entities.Channels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerAdRepo extends JpaRepository<BannerAd, Long> {
}
