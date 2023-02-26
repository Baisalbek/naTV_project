package kg.mega.naTV.entities.dto;

import kg.mega.naTV.entities.Channels;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
public class DiscountDto {
    private Long id;
    private Long discount;
    private Long discountDays;
    private Date startDate;
    private Date endDate;
    private Channels channel;
}
