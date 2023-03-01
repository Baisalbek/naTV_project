package kg.mega.naTV.entities.dto;

import kg.mega.naTV.entities.Order;
import lombok.Data;

import java.util.Date;

@Data
public class OrderDateDto {
    private Long id;
    private Date days;
    private Order order;

}
