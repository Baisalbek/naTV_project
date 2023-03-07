package kg.mega.naTV.service.Impl;

import kg.mega.naTV.entities.Channels;
import kg.mega.naTV.entities.Discounts;
import kg.mega.naTV.entities.dto.ChannelDto;
import kg.mega.naTV.entities.dto.DiscountDto;
import kg.mega.naTV.entities.dto.response.ChannelCalcDto;
import kg.mega.naTV.entities.dto.response.ChannelGetListDto;
import kg.mega.naTV.mappers.ChannelMapper;
import kg.mega.naTV.mappers.DiscountMapper;
import kg.mega.naTV.repository.ChannelRepo;
import kg.mega.naTV.repository.DiscountRepo;
import kg.mega.naTV.repository.PriceRepo;
import kg.mega.naTV.service.ChannelService;
import lombok.AllArgsConstructor;
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

    public Channels registration(ChannelDto channelDto) throws Exception {
        if (channelRepo.findByChannelName(channelDto.getChannelName()) != null) {
            throw new Exception("Канал с таким названием уже существует!");
        }
        return channelRepo.save(channelMapper.toEntity(channelDto));
    }

    public List<ChannelGetListDto> getChannelList() {
        List<Channels> channelsList = channelRepo.findAll();
        List<ChannelGetListDto> channelGetListDtoList = channelMapper.ListToDto(channelsList);
        for (int i = 0; i < channelGetListDtoList.size(); i++) {
            channelGetListDtoList.get(i).setPricePerLetter(priceRepo.findById(channelGetListDtoList.get(i)
                    .getId()).get().getPricePerLetter());
            List<Discounts> discountsList = discountRepo.findAll();
            List<DiscountDto> discountDtoList = discountMapper.ListToDto(discountsList);
            channelGetListDtoList.get(i).setDiscounts(discountMapper.ListToDto(discountRepo.findAllByChannelId(channelGetListDtoList.get(i).getId())));
        }
        return channelGetListDtoList;
    }

    public ChannelCalcDto calcDto(ChannelCalcDto channelCalcDto) {
        Long disc = 0l;
        channelCalcDto.setText(channelCalcDto.getText());
        channelCalcDto.setDaysCount(channelCalcDto.getDaysCount());
        channelCalcDto.setChannelId(channelCalcDto.getChannelId());
        Double totalPrice = priceRepo.findByChannelsId(channelCalcDto.getChannelId()).getPricePerLetter() * inputText(channelCalcDto.getText()) * channelCalcDto.getDaysCount();
        channelCalcDto.setPrice(totalPrice);
        List<Discounts> discountsList = discountRepo.findAllByChannelId(channelCalcDto.getChannelId());
        if (discountsList == null) {
            channelCalcDto.setPriceWithDiscount(totalPrice);
        } else {
            for (int i = 0; i < discountsList.size(); i++) {
                if (channelCalcDto.getDaysCount() >= discountsList.get(i).getFromDayCount()) {
                    disc = discountsList.get(i).getDiscount();
                }
            }
            channelCalcDto.setPriceWithDiscount(totalPrice - ((double) disc * 100) / totalPrice);
        }
        return channelCalcDto;
    }

    public Long inputText(String text) {
        Long spaces = text.chars().filter(c -> c == ' ').count();
        Long countOfSymbols = text.length() - spaces;
        return countOfSymbols;
    }

}
