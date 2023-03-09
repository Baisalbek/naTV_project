package kg.mega.naTV.service;

import kg.mega.naTV.entities.Discounts;
import kg.mega.naTV.entities.Price;
import kg.mega.naTV.entities.dto.DiscountDto;
import org.springframework.http.ResponseEntity;

public interface DiscountService {
    Discounts getDiscount(Long id);
    ResponseEntity setDiscount(DiscountDto discountDto);
}
