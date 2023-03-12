package kg.mega.naTV.entities.dto.response;

import lombok.Data;

@Data
public class ChannelCalcDto {         //DTO для расчета прайса на определенном канале
    private String text;
    private Integer daysCount;
    private Long channelId;
    private Double price;
    private Double priceWithDiscount;
}
