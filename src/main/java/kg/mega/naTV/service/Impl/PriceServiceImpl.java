package kg.mega.naTV.service.Impl;

import kg.mega.naTV.entities.Price;
import kg.mega.naTV.entities.dto.PriceDto;
import kg.mega.naTV.mappers.PriceMapper;
import kg.mega.naTV.repository.ChannelRepo;
import kg.mega.naTV.repository.PriceRepo;
import kg.mega.naTV.service.PriceService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceMapper priceMapper;

    private final PriceRepo priceRepo;

    private final ChannelRepo channelRepo;

    public PriceServiceImpl(PriceMapper priceMapper, PriceRepo priceRepo, ChannelRepo channelRepo) {
        this.priceMapper = priceMapper;
        this.priceRepo = priceRepo;
        this.channelRepo = channelRepo;
    }

    public ResponseEntity<?> setPrice(PriceDto priceDto) {
        priceDto.setChannels(channelRepo.findById(priceDto.getChannels().getId()).get());
        Price price = priceMapper.toEntity(priceDto);
        return ResponseEntity.ok(priceRepo.save(price));
    }
}
