package kg.mega.naTV.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class TextAdDto {
    @JsonIgnore
    private Long id;
    private String text;
    @JsonIgnore
    private Long countOfSymbols;

}
