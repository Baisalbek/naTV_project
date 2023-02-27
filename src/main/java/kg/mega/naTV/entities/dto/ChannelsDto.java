package kg.mega.naTV.entities.dto;

import kg.mega.naTV.entities.Discounts;
import kg.mega.naTV.entities.Price;
import lombok.Data;

@Data
public class ChannelsDto {
    private Long id;
    private String channelName;
    private String logo;
    private Integer pricePerLetter;
    private DiscountDto discountDto;
    
}
