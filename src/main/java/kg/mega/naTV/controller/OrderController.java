package kg.mega.naTV.controller;

import kg.mega.naTV.entities.dto.OrderDto;
import kg.mega.naTV.entities.dto.request.GetOrderDto;
import kg.mega.naTV.entities.dto.response.SaveOrderDto;
import kg.mega.naTV.mappers.OrderMapper;
import kg.mega.naTV.service.Impl.OrderServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Order")
public class OrderController {
    private final OrderServiceImpl orderServiceImpl;
    private final OrderMapper orderMapper;

    public OrderController(OrderServiceImpl orderServiceImpl, OrderMapper orderMapper) {
        this.orderServiceImpl = orderServiceImpl;

        this.orderMapper = orderMapper;
    }

    @PostMapping("/save")
    public GetOrderDto getOrder(@RequestBody GetOrderDto getOrderDto){
        return orderServiceImpl.saveOrder(getOrderDto);
    }
    @GetMapping("/saveOrder")
    public SaveOrderDto saveOrder(@RequestBody SaveOrderDto saveOrderDto){
       return orderServiceImpl.createOrder(saveOrderDto);
    }

}
