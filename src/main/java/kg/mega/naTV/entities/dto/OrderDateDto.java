package kg.mega.naTV.entities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import kg.mega.naTV.entities.Order;
import lombok.Data;

import java.util.Date;

@Data
public class OrderDateDto {
    private Long id;
    @JsonProperty("dd.mm.yyyy")
    private Date days;
    private Order order;
}
