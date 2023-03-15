package kg.mega.naTV.mappers;

import kg.mega.naTV.entities.Discounts;
import kg.mega.naTV.entities.dto.DiscountDto;
import kg.mega.naTV.entities.dto.response.DiscountGetDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DiscountMapper {
    DiscountDto toDto(Discounts discounts);

    Discounts toEntity(DiscountDto discountDto);

    List<DiscountDto> ListToDto(List<Discounts> discountsList);

    List<DiscountGetDto> EntityListToDto(List<Discounts> discountsList);

    List<Discounts> ListToEntity(List<DiscountDto> discountDtoList);
}
