package kg.mega.naTV.service;

import kg.mega.naTV.entities.TextAd;
import kg.mega.naTV.entities.dto.TextAdDto;
import org.springframework.http.ResponseEntity;

public interface TextAdService {
    ResponseEntity<?> inputText(TextAdDto textAdDto);

    TextAd getText(Long id);
}
