package kg.mega.naTV.entities.dto;

import kg.mega.naTV.entities.dto.response.OrderedChannelsDto;
import kg.mega.naTV.entities.enums.OrderStatus;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    private Long id;
    private String clientEmail;
    private String clientFIO;
    private String clientPhone;
    private List<OrderedChannelsDto> channels;
    private TextAdDto textAd;
    private Double totalPrice;
    private OrderStatus status;
}