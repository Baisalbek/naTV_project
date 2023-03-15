package kg.mega.naTV.entities;

import kg.mega.naTV.entities.enums.OrderStatus;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "tb_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientEmail;
    private String clientFIO;
    private String clientPhone;
    @OneToMany
    private List<OrderedChannels> channels;
    @ManyToOne
    private TextAd textAd;
    private Double totalPrice;
    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;
}
