package kg.mega.naTV.mappers;

import kg.mega.naTV.entities.TextAd;
import kg.mega.naTV.entities.dto.TextAdDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TextAdMapper {
    public TextAdDto toDto(TextAd textAd);
    public TextAd toEntity(TextAdDto textAdDto);

    public List<TextAdDto> ListToDto(List<TextAd> textAdList);
    public List<TextAd> ListToEntity(List<TextAdDto> textAdDtoList);

}
