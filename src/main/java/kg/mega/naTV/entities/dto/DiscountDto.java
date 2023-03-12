package kg.mega.naTV.entities.dto;

import kg.mega.naTV.entities.Channels;
import lombok.Data;

@Data
public class DiscountDto {
    private Long id;
    private Long fromDayCount;
    private Long discount;
    private ChannelDto channel;
}
