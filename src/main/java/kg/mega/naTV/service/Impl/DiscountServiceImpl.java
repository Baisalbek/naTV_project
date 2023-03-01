package kg.mega.naTV.service.Impl;

import kg.mega.naTV.entities.Discounts;
import kg.mega.naTV.entities.dto.DiscountDto;
import kg.mega.naTV.mappers.DiscountMapper;
import kg.mega.naTV.repository.ChannelRepo;
import kg.mega.naTV.repository.DiscountRepo;
import kg.mega.naTV.service.DiscountService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepo discountRepo;
    private final ChannelRepo channelRepo;
    private final DiscountMapper discountMapper;

    public DiscountServiceImpl(DiscountRepo discountRepo, ChannelRepo channelRepo, DiscountMapper discountMapper) {
        this.discountRepo = discountRepo;
        this.channelRepo = channelRepo;
        this.discountMapper = discountMapper;
    }

    public ResponseEntity<?> setDiscount(DiscountDto discountDto) {
        discountDto.setChannel(channelRepo.findById(discountDto.getChannel().getId()).get());
        Discounts discounts = discountMapper.toEntity(discountDto);
        return ResponseEntity.ok(discountRepo.save(discounts));
    }

    @Override
    public Discounts getDiscount(Long id) {
        return discountRepo.findById(id).get();
    }
}
