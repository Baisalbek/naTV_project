package kg.mega.naTV.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import kg.mega.naTV.entities.Channels;
import lombok.Data;

@Data
public class DiscountDto {
    @JsonIgnore
    private Long id;
    private Long fromDayCount;
    private Long discount;
    @JsonIgnore
    private Channels channel;
}
