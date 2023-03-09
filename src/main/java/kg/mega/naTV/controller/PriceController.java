package kg.mega.naTV.controller;

import io.swagger.annotations.ApiOperation;
import kg.mega.naTV.entities.Price;
import kg.mega.naTV.entities.dto.PriceDto;
import kg.mega.naTV.service.Impl.PriceServiceImpl;
import kg.mega.naTV.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/price")
public class PriceController {
    private  final PriceService priceService;
    @ApiOperation("Установка цены на каналы.")
    @PostMapping("/set")
    public ResponseEntity setPrice(@RequestBody PriceDto priceDto) {
        try {
            priceService.setPrice(priceDto);
            return ResponseEntity.ok().body("Цена для канала установлена!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Цена не установлена");
        }
    }
    @ApiOperation("Получение цен по id.")
    @GetMapping("/get")
    public Price getPrice(@RequestParam Long id){
      return priceService.getPrice(id);

    }
}
