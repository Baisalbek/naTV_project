package kg.mega.naTV.entities.dto.response;

import kg.mega.naTV.entities.Channels;
import lombok.Data;

@Data
public class PriceGetListDto {
    private Long id;
    private Double pricePerLetter;
    private Double pricePerBanner;
    private Long channel_id;
}
