package kg.mega.naTV.mappers;

import kg.mega.naTV.entities.Discount;
import kg.mega.naTV.entities.dto.DiscountDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DiscountMapper {
    public DiscountDto toDto(Discount discount);
    public Discount toEntity(DiscountDto discountDto);

    public List<DiscountDto> ListToDto(List<Discount> discountList);
    public List<Discount> ListToEntity(List<DiscountDto> discountDtoList);

}
