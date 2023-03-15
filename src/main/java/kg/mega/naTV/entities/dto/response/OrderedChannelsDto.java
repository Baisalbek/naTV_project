package kg.mega.naTV.entities.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.mega.naTV.entities.OrderedDays;
import lombok.Data;

import java.util.List;

@Data
public class OrderedChannelsDto { // DTO для информации по каналу внутри заказа
    @JsonIgnore
    private Long id;
    private Long channelId;
    private List<OrderedDays> days;
    private Double price;
    private Double priceWithDiscount;
    @JsonIgnore
    private Long orderId;
}
