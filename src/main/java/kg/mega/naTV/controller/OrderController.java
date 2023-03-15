package kg.mega.naTV.controller;

import io.swagger.annotations.ApiOperation;
import kg.mega.naTV.entities.Order;
import kg.mega.naTV.entities.dto.response.SaveOrderDto;
import kg.mega.naTV.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;

    @ApiOperation("Сохранение заказа.")
    @PostMapping("/save-order")
    public SaveOrderDto saveOrder(@RequestBody SaveOrderDto saveOrderDto) {
        return orderService.createOrder(saveOrderDto);
    }

    @ApiOperation("Получение заказов по номеру телефона.")
    @GetMapping("/get-order")
    public List<Order> getOrder(@RequestParam String clientPhone) {
        return orderService.getOrder(clientPhone);
    }
}
