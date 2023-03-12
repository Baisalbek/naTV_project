package kg.mega.naTV.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "channel_for_order")
public class ChannelForOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long channelId;
    @OneToMany
    private List<OrderedDates> days;
    private Double price;
    private Double priceWithDiscount;
}
