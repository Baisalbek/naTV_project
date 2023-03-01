package kg.mega.naTV.service;

import kg.mega.naTV.entities.Price;
import kg.mega.naTV.entities.dto.PriceDto;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface PriceService {
    ResponseEntity<?> setPrice(PriceDto priceDto);
    Price getPrice(Long id);
}
