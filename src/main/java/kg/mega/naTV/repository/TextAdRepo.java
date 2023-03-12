package kg.mega.naTV.repository;

import kg.mega.naTV.entities.TextAd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextAdRepo extends JpaRepository<TextAd, Long> {
}
