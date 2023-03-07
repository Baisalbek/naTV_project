package kg.mega.naTV.controller;

import kg.mega.naTV.entities.OrderDate;
import kg.mega.naTV.entities.dto.OrderDateDto;
import kg.mega.naTV.mappers.OrderDateMapper;
import kg.mega.naTV.service.Impl.OrderDateServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/OrderDate")
public class OrderDateController {
    private final OrderDateServiceImpl orderDateServiceImpl;
    private final OrderDateMapper orderDateMapper;

    public OrderDateController(OrderDateServiceImpl orderDateServiceImpl, OrderDateMapper orderDateMapper) {
        this.orderDateServiceImpl = orderDateServiceImpl;
        this.orderDateMapper = orderDateMapper;
    }

    @PostMapping("/dates")
    public ResponseEntity getDates(OrderDateDto orderDateDto){
        try {
            orderDateServiceImpl.selectDate(orderDateDto);
            return ResponseEntity.ok().body("Даты выбраны!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Даты не выбраны");
        }
    }
    @GetMapping("/getDates")
    public OrderDate orderDate(@RequestParam Long id){
        return orderDateServiceImpl.getOrderDate(id);
    }
}
