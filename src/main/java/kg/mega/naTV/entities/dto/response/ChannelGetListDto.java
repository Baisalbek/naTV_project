package kg.mega.naTV.entities.dto.response;

import kg.mega.naTV.entities.dto.DiscountDto;
import lombok.Data;

import java.util.List;

@Data
public class ChannelGetListDto {
    private Long id;
    private String channelName;
    private String logo;
    private Double pricePerLetter;
    private List<DiscountDto> discounts;

}
