package kg.mega.naTV.service;

import kg.mega.naTV.entities.Discounts;
import kg.mega.naTV.entities.dto.DiscountDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DiscountService {
    List<Discounts> getDiscount(Long id);

    ResponseEntity setDiscount(DiscountDto discountDto);
}
