package kg.mega.naTV.mappers;

import kg.mega.naTV.entities.Price;
import kg.mega.naTV.entities.dto.PriceDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PriceMapper {
    PriceDto toDto(Price price);

    Price toEntity(PriceDto priceDto);

    List<PriceDto> ListToDto(List<Price> priceList);

    List<Price> ListToEntity(List<PriceDto> priceDtoList);
}
