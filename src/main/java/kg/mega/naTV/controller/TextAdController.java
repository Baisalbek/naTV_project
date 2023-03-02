package kg.mega.naTV.controller;

import kg.mega.naTV.entities.TextAd;
import kg.mega.naTV.entities.dto.TextAdDto;
import kg.mega.naTV.mappers.TextAdMapper;
import kg.mega.naTV.service.Impl.TextAdServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Text")
public class TextAdController {
    private final TextAdServiceImpl textAdService;
    private final TextAdMapper textAdMapper;

    @PostMapping("/Input")
    public ResponseEntity inputText(@RequestBody TextAdDto textAdDto){
        try {
            textAdService.inputText(textAdDto);
            return ResponseEntity.ok().body("Текст сохранен!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Тексте не сохранен!");
        }
    }
    @GetMapping("/getText")
    public TextAd getText(@RequestParam Long id){
        return textAdService.getText(id);
    }
}
