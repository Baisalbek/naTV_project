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
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double pricePerLetter;
    private Double pricePerBanner;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channels channels;


}
