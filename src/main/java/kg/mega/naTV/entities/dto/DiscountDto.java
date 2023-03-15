package kg.mega.naTV.entities.dto;

import lombok.Data;

@Data
public class DiscountDto {
    private Long id;
    private Long fromDayCount;
    private Long discount;
    private ChannelDto channel;
}
