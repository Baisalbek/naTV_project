package kg.mega.naTV.mappers;

import kg.mega.naTV.entities.Order;
import kg.mega.naTV.entities.dto.OrderDto;
import kg.mega.naTV.entities.dto.response.SaveOrderDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    public OrderDto toDto(Order order);
    public Order toEntity(SaveOrderDto orderDto);

    public List<OrderDto> ListToDto(List<Order> orderList);
    public List<Order> ListToEntity(List<OrderDto> orderDtoList);

}
