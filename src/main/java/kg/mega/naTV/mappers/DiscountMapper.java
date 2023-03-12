package kg.mega.naTV.mappers;

import kg.mega.naTV.entities.Discounts;
import kg.mega.naTV.entities.dto.DiscountDto;
import kg.mega.naTV.entities.dto.response.DiscountGetDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DiscountMapper {
    public DiscountDto toDto(Discounts discounts);

    public Discounts toEntity(DiscountDto discountDto);

    public List<DiscountDto> ListToDto(List<Discounts> discountsList);

    public List<DiscountGetDto> EntityListToDto(List<Discounts> discountsList);

    public List<Discounts> ListToEntity(List<DiscountDto> discountDtoList);


}
