package kg.mega.naTV.repository;

import kg.mega.naTV.entities.Order;
import kg.mega.naTV.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.prefs.PreferenceChangeEvent;

@Repository
public interface PriceRepo extends JpaRepository<Price, Long> {
}
