package kg.mega.naTV.mappers;

import kg.mega.naTV.entities.Order;
import kg.mega.naTV.entities.dto.OrderDto;
import org.aspectj.weaver.ast.Or;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    public OrderDto toDto(Order order);
    public Order toEntity(OrderDto orderDto);

    public List<OrderDto> ListToDto(List<Order> orderList);
    public List<Order> ListToEntity(List<OrderDto> orderDtoList);

}
