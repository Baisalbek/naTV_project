package kg.mega.naTV.controller;

import kg.mega.naTV.entities.Discounts;
import kg.mega.naTV.entities.dto.DiscountDto;
import kg.mega.naTV.entities.dto.PriceDto;
import kg.mega.naTV.service.Impl.DiscountServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Discounts")
public class DiscountController {
    private final DiscountServiceImpl discountServiceImpl;

    public DiscountController(DiscountServiceImpl discountServiceImpl) {
        this.discountServiceImpl = discountServiceImpl;
    }

    @PostMapping("/set")
    public ResponseEntity setDiscount(@RequestBody DiscountDto discountDto) {
        try {
            discountServiceImpl.setDiscount(discountDto);
            return ResponseEntity.ok().body("Скидка для канала установлена!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Скидка для канала не установлена");
        }
    }
    @GetMapping("/get")
    public Discounts getDiscount(@RequestParam Long id){
        return discountServiceImpl.getDiscount(id);
    }
}
