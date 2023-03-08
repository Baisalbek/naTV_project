package kg.mega.naTV.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.mega.naTV.entities.BannerAd;
import kg.mega.naTV.entities.Channels;
import kg.mega.naTV.entities.TextAd;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    private Long id;
    private String clientEmail;
    private String clientFIO;
    private String  clientPhone;
    private List<Channels> channels;
    private TextAd textAd;
    private Double totalPrice;
    private String status;
}