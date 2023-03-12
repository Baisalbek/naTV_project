package kg.mega.naTV.service.Impl;

import kg.mega.naTV.entities.Discounts;
import kg.mega.naTV.entities.dto.DiscountDto;
import kg.mega.naTV.mappers.ChannelMapper;
import kg.mega.naTV.mappers.DiscountMapper;
import kg.mega.naTV.repository.ChannelRepo;
import kg.mega.naTV.repository.DiscountRepo;
import kg.mega.naTV.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepo discountRepo;
    private final ChannelRepo channelRepo;
    private final DiscountMapper discountMapper;
    private final ChannelMapper channelMapper;

    @Override
    public ResponseEntity<?> setDiscount(DiscountDto discountDto) {
        discountDto.setChannel(channelMapper.EntityTtoDto(channelRepo.findById(discountDto.getChannel().getId()).get()));
        Discounts discounts = discountMapper.toEntity(discountDto);
        return ResponseEntity.ok(discountRepo.save(discounts));
    }

    @Override
    public List<Discounts> getDiscount(Long id) {
        return discountRepo.findAllByChannelId(id);
    }
}
