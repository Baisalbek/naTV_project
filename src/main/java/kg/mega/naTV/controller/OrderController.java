package kg.mega.naTV.controller;

import io.swagger.annotations.ApiOperation;
import kg.mega.naTV.entities.dto.request.GetOrderDto;
import kg.mega.naTV.entities.dto.response.SaveOrderDto;
import kg.mega.naTV.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

//    @ApiOperation("///.")
//    @PostMapping("/save")
//    public GetOrderDto getOrder(@RequestBody GetOrderDto getOrderDto) {
//        return orderService.saveOrder(getOrderDto);
//    }

    @ApiOperation("Сохранение заказа.")
    @PostMapping("/saveOrder")
    public SaveOrderDto saveOrder(@RequestBody SaveOrderDto saveOrderDto) {
        return orderService.createOrder(saveOrderDto);
    }
}
