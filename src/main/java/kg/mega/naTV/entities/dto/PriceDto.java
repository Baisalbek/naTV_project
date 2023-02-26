package kg.mega.naTV.entities.dto;

import kg.mega.naTV.entities.Channels;
import lombok.Data;

@Data
public class PriceDto {
    private Long id;
    private Double priceOfLine;
    private Double priceOfBanner;
    private Channels channels;
}
