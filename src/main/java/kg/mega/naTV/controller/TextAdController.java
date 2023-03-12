package kg.mega.naTV.controller;

import io.swagger.annotations.ApiOperation;
import kg.mega.naTV.entities.TextAd;
import kg.mega.naTV.entities.dto.TextAdDto;
import kg.mega.naTV.service.Impl.TextAdServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/text")
public class TextAdController {
    private final TextAdServiceImpl textAdService;

    @ApiOperation("Сохранение текста для создания закза.")
    @PostMapping("/input-text")
    public ResponseEntity inputText(@RequestBody TextAdDto textAdDto) {
        try {
            textAdService.inputText(textAdDto);
            return ResponseEntity.ok().body("Текст сохранен!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Тексте не сохранен!");
        }
    }

    @ApiOperation("Получение текста по id.")
    @GetMapping("/get-text")
    public TextAd getText(@RequestParam Long id) {
        return textAdService.getText(id);
    }
}
