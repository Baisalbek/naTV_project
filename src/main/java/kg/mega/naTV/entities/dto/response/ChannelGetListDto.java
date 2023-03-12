package kg.mega.naTV.entities.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class ChannelGetListDto {    //DTO для получения списка каналов
    private Long id;
    private String channelName;
    private String logo;
    private Double pricePerLetter;
    private List<DiscountGetDto> discounts;

}
