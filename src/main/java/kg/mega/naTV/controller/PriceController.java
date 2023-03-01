package kg.mega.naTV.controller;

import kg.mega.naTV.entities.Price;
import kg.mega.naTV.entities.dto.PriceDto;
import kg.mega.naTV.service.Impl.PriceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/price")
public class PriceController {
    private  final PriceServiceImpl priceServiceImpl;

    @PostMapping("/set")
    public ResponseEntity setPrice(@RequestBody PriceDto priceDto) {
        try {
            priceServiceImpl.setPrice(priceDto);
            return ResponseEntity.ok().body("Цена для канала установлена!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Цена не установлена");
        }
    }
    @GetMapping("/get")
    public Price getPrice(@RequestParam Long id){
      return priceServiceImpl.getPrice(id);

    }
}
