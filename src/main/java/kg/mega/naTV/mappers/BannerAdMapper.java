package kg.mega.naTV.mappers;

import kg.mega.naTV.entities.BannerAd;
import kg.mega.naTV.entities.dto.BannerAdDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BannerAdMapper {
    public BannerAdDto toDto(BannerAd bannerAd);
    public BannerAd toEntity(BannerAdDto bannerAdDto);

    public List<BannerAdDto> ListToDto(List<BannerAdDto> bannerAdDtoList);
    public List<BannerAd> ListToEntity(List<BannerAdDto> bannerAdDtoList);

}
