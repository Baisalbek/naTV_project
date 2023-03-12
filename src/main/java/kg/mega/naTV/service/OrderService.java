package kg.mega.naTV.service;

import kg.mega.naTV.entities.Order;
import kg.mega.naTV.entities.dto.OrderDto;
import kg.mega.naTV.entities.dto.response.SaveOrderDto;

public interface OrderService {
    SaveOrderDto createOrder(SaveOrderDto saveOrderDto);

    Order getOrder(String clientPhone);

}
