package kg.mega.naTV.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "tb_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Channels channels;

    @ManyToOne
    private TextAd textAd;

    @ManyToOne
    private BannerAd bannerAd;

    @ManyToOne
    private Users user;

    private Double orderSumm;
    private String paymentStatus;

}
