package kg.mega.naTV.controller;

import kg.mega.naTV.entities.OrderDate;
import kg.mega.naTV.entities.dto.OrderDateDto;
import kg.mega.naTV.service.OrderDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/OrderDate")
public class OrderDateController {
    private final OrderDateService orderDateService;

    @PostMapping("/dates")
    public ResponseEntity getDates(OrderDateDto orderDateDto) {
        try {
            orderDateService.selectDate(orderDateDto);
            return ResponseEntity.ok().body("Даты выбраны!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Даты не выбраны");
        }
    }

    @GetMapping("/getDates")
    public OrderDate orderDate(@RequestParam Long id) {
        return orderDateService.getOrderDate(id);
    }
}
