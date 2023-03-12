package kg.mega.naTV.entities.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotEmpty;

@Data
@Validated
public class ChannelDto {
    private Long id;
    @NotEmpty
    private String channelName;
    @NotEmpty
    private String logo;
}
