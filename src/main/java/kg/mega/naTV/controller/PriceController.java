package kg.mega.naTV.controller;

import kg.mega.naTV.entities.dto.PriceDto;
import kg.mega.naTV.service.Impl.PriceServiceImpl;
import kg.mega.naTV.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/price")
public class PriceController {
    private  final PriceServiceImpl priceServiceImpl;

    @PostMapping("/set")
    public ResponseEntity setPrice(@RequestBody PriceDto priceDto) {
//        return  priceService.setPrice(priceDto);
        try {
            priceServiceImpl.setPrice(priceDto);
            return ResponseEntity.ok().body("Цена для канала установлена!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Цена не установлена");
        }
    }
}
