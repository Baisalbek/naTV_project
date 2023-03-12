package kg.mega.naTV.mappers;

import kg.mega.naTV.entities.Price;
import kg.mega.naTV.entities.dto.PriceDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PriceMapper {
    public PriceDto toDto(Price price);

    public Price toEntity(PriceDto priceDto);

    public List<PriceDto> ListToDto(List<Price> priceList);

    public List<Price> ListToEntity(List<PriceDto> priceDtoList);

}
