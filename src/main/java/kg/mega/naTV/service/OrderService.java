package kg.mega.naTV.service;

import kg.mega.naTV.entities.dto.request.GetOrderDto;
import kg.mega.naTV.entities.dto.response.SaveOrderDto;

public interface OrderService {
    GetOrderDto saveOrder(GetOrderDto getOrderDto);

    SaveOrderDto createOrder(SaveOrderDto saveOrderDto);
}
