package kg.mega.naTV.service.Impl;

import kg.mega.naTV.entities.Channels;
import kg.mega.naTV.entities.Discounts;
import kg.mega.naTV.entities.dto.ChannelsDto;
import kg.mega.naTV.entities.dto.DiscountDto;
import kg.mega.naTV.mappers.ChannelMapper;
import kg.mega.naTV.mappers.DiscountMapper;
import kg.mega.naTV.repository.ChannelRepo;
import kg.mega.naTV.repository.DiscountRepo;
import kg.mega.naTV.repository.PriceRepo;
import kg.mega.naTV.service.ChannelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService {
    private final ChannelRepo channelRepo;
    private final ChannelMapper channelMapper;
    private final PriceRepo priceRepo;
    private final DiscountRepo discountRepo;
    private final DiscountMapper discountMapper;
    public ChannelServiceImpl(ChannelRepo channelRepo, ChannelMapper channelMapper, PriceRepo priceRepo, DiscountRepo discountRepo, DiscountMapper discountMapper) {
        this.channelRepo = channelRepo;
        this.channelMapper = channelMapper;
        this.priceRepo = priceRepo;
        this.discountRepo = discountRepo;
        this.discountMapper = discountMapper;
    }

    public Channels registration(ChannelsDto channelsDto) throws Exception {
        if (channelRepo.findByChannelName(channelsDto.getChannelName()) != null) {
            throw new Exception("Канал с таким названием уже существует!");
        }
        return channelRepo.save(channelMapper.toEntity(channelsDto));
    }

    public List<ChannelsDto> getChannelList() {
        List<Channels> channelsList = channelRepo.findAll();
        List<ChannelsDto> channelsDtoList = channelMapper.ListToDto(channelsList);
        for (int i = 0; i < channelsDtoList.size(); i++) {
        channelsDtoList.get(i).setPricePerLetter(priceRepo.findById(channelsDtoList.get(i)
                        .getId()).get().getPricePerLetter());
        List<Discounts> discountsList = discountRepo.findAll();
        List<DiscountDto> discountDtoList = discountMapper.ListToDto(discountsList);
        channelsDtoList.get(i).setDiscounts(discountMapper.ListToDto(discountRepo.findAllByChannelId(channelsDtoList.get(i).getId())));
    }
        return channelsDtoList;
    }
}
