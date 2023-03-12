package kg.mega.naTV.entities.dto;

import kg.mega.naTV.entities.Channels;
import lombok.Data;

@Data
public class PriceDto {
    private Long id;
    private Double pricePerLetter;
    private ChannelDto channels;
}
