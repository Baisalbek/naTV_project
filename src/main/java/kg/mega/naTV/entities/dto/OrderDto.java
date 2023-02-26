package kg.mega.naTV.entities.dto;

import kg.mega.naTV.entities.BannerAd;
import kg.mega.naTV.entities.Channels;
import kg.mega.naTV.entities.TextAd;
import kg.mega.naTV.entities.Users;
import lombok.Data;

@Data
public class OrderDto {
    private Long id;
    private Channels channels;
    private TextAd textAd;
    private BannerAd bannerAd;
    private Users user;
}
