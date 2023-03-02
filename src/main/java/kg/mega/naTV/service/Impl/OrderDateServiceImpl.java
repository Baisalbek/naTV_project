package kg.mega.naTV.service.Impl;

import kg.mega.naTV.entities.OrderDate;
import kg.mega.naTV.entities.Price;
import kg.mega.naTV.entities.dto.OrderDateDto;
import kg.mega.naTV.mappers.OrderDateMapper;
import kg.mega.naTV.repository.OrderDateRepo;
import kg.mega.naTV.service.OrderDateService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderDateServiceImpl implements OrderDateService {
    private final OrderDateRepo orderDateRepo;
    private final OrderDateMapper orderDateMapper;

    public ResponseEntity<?> selectDate(OrderDateDto orderDateDto) {
    OrderDate orderDate = orderDateMapper.toEntity(orderDateDto);
    return ResponseEntity.ok(orderDateRepo.save(orderDate));
    }

    public OrderDate getOrderDate(Long id) {
        return orderDateRepo.findById(id).get();
    }

}
