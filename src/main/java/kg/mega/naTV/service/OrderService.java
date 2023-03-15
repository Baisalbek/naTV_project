package kg.mega.naTV.service;

import kg.mega.naTV.entities.Order;
import kg.mega.naTV.entities.dto.response.SaveOrderDto;

import java.util.List;

public interface OrderService {
    SaveOrderDto createOrder(SaveOrderDto saveOrderDto);

    List<Order> getOrder(String clientPhone);
}
