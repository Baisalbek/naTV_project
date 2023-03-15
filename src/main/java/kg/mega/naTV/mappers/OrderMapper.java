package kg.mega.naTV.mappers;

import kg.mega.naTV.entities.Order;
import kg.mega.naTV.entities.dto.OrderDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderDto toDto(Order order);

    Order toEntity(OrderDto orderDto);

    List<OrderDto> ListToDto(List<Order> orderList);

    List<Order> ListToEntity(List<OrderDto> orderDtoList);
}
