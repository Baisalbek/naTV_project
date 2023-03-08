package kg.mega.naTV.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class TextAdDto {

    private Long id;
    private String text;
    private Long countOfSymbols;

}
