package kg.mega.naTV.mappers;

import kg.mega.naTV.entities.TextAd;
import kg.mega.naTV.entities.dto.TextAdDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TextAdMapper {
    TextAdDto toDto(TextAd textAd);

    TextAd toEntity(TextAdDto textAdDto);

    List<TextAdDto> ListToDto(List<TextAd> textAdList);

    List<TextAd> ListToEntity(List<TextAdDto> textAdDtoList);
}
