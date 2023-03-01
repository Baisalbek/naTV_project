package kg.mega.naTV.entities.dto;

import kg.mega.naTV.entities.Channels;
import lombok.Data;

@Data
public class DiscountDto {
    private Long id;
    private Long discount;
    private Long discountDays;
    private Long fromDayCount;
    private Channels channel;
}
