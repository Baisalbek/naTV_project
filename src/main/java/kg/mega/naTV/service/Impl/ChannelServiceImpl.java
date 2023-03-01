package kg.mega.naTV.service.Impl;

import kg.mega.naTV.entities.Channels;
import kg.mega.naTV.entities.dto.ChannelsDto;
import kg.mega.naTV.mappers.ChannelMapper;
import kg.mega.naTV.repository.ChannelRepo;
import kg.mega.naTV.repository.PriceRepo;
import kg.mega.naTV.service.ChannelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService {
    private final ChannelRepo channelRepo;
    private final ChannelMapper channelMapper;
    private final PriceRepo priceRepo;

    public ChannelServiceImpl(ChannelRepo channelRepo, ChannelMapper channelMapper, PriceRepo priceRepo) {
        this.channelRepo = channelRepo;
        this.channelMapper = channelMapper;
        this.priceRepo = priceRepo;
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
        System.err.println(channelsDtoList.size());
        for (int i = 0; i < channelsDtoList.size(); i++) {
        channelsDtoList.get(i).setPricePerLetter(priceRepo.findById(channelsDtoList.get(i).
                getId()).get().getPricePerLetter());

    }
        return channelsDtoList;
    }
}
