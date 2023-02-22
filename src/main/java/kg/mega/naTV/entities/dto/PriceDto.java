package kg.mega.naTV.entities.dto;

import kg.mega.naTV.entities.Channels;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class PriceDto {
    private Long id;
    private Double priceOfLine;
    private Double priceOfBanner;
    private Channels channels;
}
