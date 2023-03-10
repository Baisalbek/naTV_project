package kg.mega.naTV.entities.dto.response;

import kg.mega.naTV.entities.enums.OrderStatus;
import lombok.Data;
import java.util.List;
@Data
public class SaveOrderDto {
    private String clientEmail;
    private String clientFIO;
    private String clientPhone;
    private String text;
    private Double totalPrice;
    private OrderStatus status;
    private List<ChannelForOrderDto> channels;
}
