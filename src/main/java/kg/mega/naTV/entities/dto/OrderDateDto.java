package kg.mega.naTV.entities.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.mega.naTV.entities.Order;
import lombok.Data;

import java.util.Date;

@Data
public class OrderDateDto {
    @JsonIgnore
    private Long id;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date days;
    @JsonIgnore
    private Order order;
}
