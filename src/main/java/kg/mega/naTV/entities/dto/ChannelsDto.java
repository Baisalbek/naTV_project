package kg.mega.naTV.entities.dto;

import kg.mega.naTV.controller.PriceController;
import kg.mega.naTV.entities.Price;
import lombok.Data;

import java.util.List;

@Data
public class ChannelsDto {
    private Long id;
    private String channelName;
    private String logo;
    private Double pricePerLetter;
    private List<DiscountDto> discounts;
}
