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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChannelServiceImpl implements ChannelService {
    private final ChannelRepo channelRepo;
    private final ChannelMapper channelMapper;
    private final PriceRepo priceRepo;
    private final DiscountRepo discountRepo;
    private final DiscountMapper discountMapper;


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
        Long disc = 0L;
        double totalPrice = priceRepo.findByChannelsId(channelCalcDto.getChannelId()).getPricePerLetter() * inputText(channelCalcDto.getText()) * channelCalcDto.getDaysCount();
        channelCalcDto.setPrice(totalPrice);
        List<Discounts> discountsList = discountRepo.findAllByChannelId(channelCalcDto.getChannelId());
        if (discountsList.size() == 0) {
            channelCalcDto.setPriceWithDiscount(totalPrice);
        } else {
            for (Discounts discounts : discountsList) {
                if (channelCalcDto.getDaysCount() >= discounts.getFromDayCount()) {
                    disc = discounts.getDiscount();
                }
            }
            double totalPriceWIthDiscount = Math.round(totalPrice - ((double) disc * 100) / totalPrice);
            channelCalcDto.setPriceWithDiscount(totalPriceWIthDiscount);
        }
        return channelCalcDto;
    }

    public Long inputText(String text) {
        Long spaces = text.chars().filter(c -> c == ' ').count();
        Long countOfSymbols = text.length() - spaces;
        return countOfSymbols;
    }

}
