package kg.mega.naTV.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_ordered_channels")
public class OrderedChannels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long channelId;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<OrderedDays> days;
    private Double price;
    private Double priceWithDiscount;
    private Long orderId;
}
