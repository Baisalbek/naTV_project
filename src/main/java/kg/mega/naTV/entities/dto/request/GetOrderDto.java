package kg.mega.naTV.entities.dto.request;

import kg.mega.naTV.entities.dto.response.ChannelGetListDto;
import lombok.Data;

import java.util.List;

@Data
public class GetOrderDto {
    private String clientEmail;
    private String clientFIO;
    private String clientPhone;
    private String text;
    private Double totalPrice;
    private String status;
    private List<ChannelGetListDto> channels;


}
