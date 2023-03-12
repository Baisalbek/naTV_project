package kg.mega.naTV.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double pricePerLetter;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channels channels;
}
