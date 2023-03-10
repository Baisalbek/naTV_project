package kg.mega.naTV.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "tb_channel")
public class Channels {
    @Id
//    @ManyToOne
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String channelName;
    private String logo;

}
