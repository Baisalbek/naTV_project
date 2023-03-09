package kg.mega.naTV.service.Impl;

import kg.mega.naTV.entities.Price;
import kg.mega.naTV.entities.dto.PriceDto;
import kg.mega.naTV.mappers.ChannelMapper;
import kg.mega.naTV.mappers.PriceMapper;
import kg.mega.naTV.repository.ChannelRepo;
import kg.mega.naTV.repository.PriceRepo;
import kg.mega.naTV.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PriceServiceImpl implements PriceService {
    private final PriceMapper priceMapper;
    private final PriceRepo priceRepo;
    private final ChannelRepo channelRepo;


    public ResponseEntity<?> setPrice(PriceDto priceDto) {
        priceDto.setChannels(channelRepo.findById(priceDto.getChannels().getId()).get());
        Price price = priceMapper.toEntity(priceDto);
        return ResponseEntity.ok(priceRepo.save(price));
    }

    @Override
    public Price getPrice(Long id) {
        return priceRepo.findById(id).get();
    }
}
