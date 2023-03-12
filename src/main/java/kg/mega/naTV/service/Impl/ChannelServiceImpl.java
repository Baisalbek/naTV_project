package kg.mega.naTV.service.Impl;

import kg.mega.naTV.entities.Channels;
import kg.mega.naTV.entities.Discounts;
import kg.mega.naTV.entities.dto.ChannelDto;
import kg.mega.naTV.entities.dto.response.ChannelCalcDto;
import kg.mega.naTV.entities.dto.response.ChannelGetListDto;
import kg.mega.naTV.entities.dto.response.DiscountGetDto;
import kg.mega.naTV.mappers.ChannelMapper;
import kg.mega.naTV.mappers.DiscountMapper;
import kg.mega.naTV.repository.ChannelRepo;
import kg.mega.naTV.repository.DiscountRepo;
import kg.mega.naTV.repository.PriceRepo;
import kg.mega.naTV.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChannelServiceImpl implements ChannelService {
    private final ChannelRepo channelRepo;
    private final ChannelMapper channelMapper;
    private final PriceRepo priceRepo;
    private final DiscountRepo discountRepo;
    private final DiscountMapper discountMapper;

    @Override
    public Channels registration(ChannelDto channelDto, MultipartFile file) throws Exception {
        if (channelRepo.findByChannelName(channelDto.getChannelName()) != null) {
            throw new Exception("Канал с таким названием уже существует!");
        } else if (file != null) {
            channelDto.setLogo(saveLogo(file));
        }
        return channelRepo.save(channelMapper.DtoToEntity(channelDto));
    }

    private String saveLogo(MultipartFile file) throws IOException {
        File logo = new File("C:\\Users\\Bektashev's\\Documents\\logos\\" + file.getOriginalFilename());
        logo.createNewFile();
        FileOutputStream output = new FileOutputStream(logo);
        output.write(file.getBytes());
        output.close();
        return logo.getAbsolutePath();
    }

    @Override
    public List<ChannelGetListDto> getChannelList() {
        List<Channels> channelsList = channelRepo.findAll();
        List<ChannelGetListDto> channelGetListDtoList = channelMapper.ListToDto(channelsList);
        for (ChannelGetListDto channelGetListDto : channelGetListDtoList) {
            channelGetListDto.setPricePerLetter(priceRepo.findById(channelGetListDto
                    .getId()).get().getPricePerLetter());
            List<Discounts> discountsList = discountRepo.findAll();
            List<DiscountGetDto> discountDtoList = discountMapper.EntityListToDto(discountsList);
            channelGetListDto.setDiscounts(discountMapper.EntityListToDto(discountRepo.findAllByChannelId(channelGetListDto.getId())));
        }
        return channelGetListDtoList;
    }

    @Override
    public ChannelCalcDto calcDto(ChannelCalcDto channelCalcDto) {
        Long disc = 0L;
        double pricePerLetter = priceRepo.findByChannelsId(channelCalcDto.getChannelId()).getPricePerLetter();
        double totalPrice = pricePerLetter * inputText(channelCalcDto.getText()) * channelCalcDto.getDaysCount();
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
        long spaces = text.chars().filter(c -> c == ' ').count();
        Long countOfSymbols = text.length() - spaces;
        return countOfSymbols;
    }

}
