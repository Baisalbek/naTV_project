package kg.mega.naTV.controller;

import io.swagger.annotations.ApiOperation;
import kg.mega.naTV.entities.Discounts;
import kg.mega.naTV.entities.dto.DiscountDto;
import kg.mega.naTV.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Discounts")
public class DiscountController {
    private final DiscountService discountService;

    @ApiOperation("Установка скидки на каналы.")
    @PostMapping("/set")
    public ResponseEntity setDiscount(@RequestBody DiscountDto discountDto) {
        try {
            discountService.setDiscount(discountDto);
            return ResponseEntity.ok().body("Скидка для канала установлена!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Скидка для канала не установлена");
        }
    }

    @ApiOperation("Получение скидки по id.")
    @GetMapping("/get")
    public Discounts getDiscount(@RequestParam Long id) {
        return discountService.getDiscount(id);
    }
}
