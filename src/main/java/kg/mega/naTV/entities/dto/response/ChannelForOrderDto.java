package kg.mega.naTV.entities.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class ChannelForOrderDto {
    private Long channelId;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private List<Date> days;
    private Double price;
    private Double priceWithDiscount;
}
//Сделать сущьность этого ДТО
//
