package kg.mega.naTV.mappers;

import kg.mega.naTV.entities.OrderDate;
import kg.mega.naTV.entities.dto.OrderDateDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OrderDateMapper {
    public OrderDateDto toDto(OrderDate orderDate);
    public OrderDate toEntity(OrderDateDto orderDateDto);

    public List<OrderDateDto> ListToDto(List<OrderDate> orderDateList);
    public List<OrderDate> ListToEntity(List<OrderDateDto> orderDateDtoList);

}
