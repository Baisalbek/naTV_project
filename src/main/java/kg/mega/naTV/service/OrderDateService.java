package kg.mega.naTV.service;

import kg.mega.naTV.entities.OrderDate;
import kg.mega.naTV.entities.dto.OrderDateDto;
import org.springframework.http.ResponseEntity;

public interface OrderDateService {
    ResponseEntity selectDate(OrderDateDto orderDateDto);

    OrderDate getOrderDate(Long id);
}
