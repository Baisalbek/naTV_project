package kg.mega.naTV.service.Impl;

import kg.mega.naTV.entities.Discounts;
import kg.mega.naTV.entities.dto.request.GetOrderDto;
import kg.mega.naTV.entities.dto.response.ChannelForOrderDto;
import kg.mega.naTV.entities.dto.response.SaveOrderDto;
import kg.mega.naTV.mappers.OrderMapper;
import kg.mega.naTV.repository.DiscountRepo;
import kg.mega.naTV.repository.OrderRepo;
import kg.mega.naTV.repository.PriceRepo;
import kg.mega.naTV.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final OrderMapper orderMapper;
    private final PriceRepo priceRepo;
    private final DiscountRepo discountRepo;

    public GetOrderDto saveOrder(GetOrderDto getOrderDto) {
        getOrderDto.setClientEmail(getOrderDto.getClientEmail());
        getOrderDto.setClientFIO(getOrderDto.getClientFIO());
        getOrderDto.setClientPhone(getOrderDto.getClientPhone());
        getOrderDto.setText(getOrderDto.getText());
        getOrderDto.setStatus("CREATED");
        getOrderDto.setChannels(getOrderDto.getChannels());
        return getOrderDto;
//        channelRepo.findByChannelName(channelsDto.getChannelName()
    }

    public SaveOrderDto createOrder(SaveOrderDto saveOrderDto) {
        saveOrderDto.setClientEmail(saveOrderDto.getClientEmail());
        saveOrderDto.setClientFIO(saveOrderDto.getClientFIO());
        saveOrderDto.setClientPhone(saveOrderDto.getClientPhone());
        saveOrderDto.setText(saveOrderDto.getText());
        saveOrderDto.setStatus("CREATED");
        for (int i = 0; i < saveOrderDto.getChannels().size(); i++) {
            ChannelForOrderDto channel = saveOrderDto.getChannels().get(i);
            channel.setChannelId(saveOrderDto.getChannels().get(i).getChannelId());
            channel.setDays(saveOrderDto.getChannels().get(i).getDays());
            Long spaces = saveOrderDto.getText().chars().filter(c -> c == ' ').count();
            Long countOfSymbols = saveOrderDto.getText().length() - spaces;
            channel.setPrice(priceRepo.findById(saveOrderDto.getChannels().get(i).getChannelId()).get().
                    getPricePerLetter() * countOfSymbols *
                    saveOrderDto.getChannels().get(i).getDays().size());
            Long disc = 0l;
            List<Discounts> discountsList = discountRepo.findAllByChannelId(saveOrderDto.getChannels().get(i).getChannelId());
            if (discountsList == null) {
                saveOrderDto.getChannels().get(i).setPriceWithDiscount(saveOrderDto.getChannels().get(i).getPrice());
            } else {
                for (int j = 0; j < discountsList.size(); j++) {
                    if (saveOrderDto.getChannels().get(i).getDays().size() >= discountsList.get(j).getFromDayCount()) {
                        disc = discountsList.get(j).getDiscount();
                    }
                }
                channel.setPriceWithDiscount(saveOrderDto.getChannels().get(i).getPrice() - ((double) disc * 100) / saveOrderDto.getChannels().get(i).getPrice());
            }
            Double oneChannelPrice = saveOrderDto.getChannels().get(i).getPriceWithDiscount();
            Double sumPrice = oneChannelPrice + saveOrderDto.getChannels().get(i).getPriceWithDiscount();
            saveOrderDto.setTotalPrice(sumPrice);
        }
        return saveOrderDto;
    }
}
