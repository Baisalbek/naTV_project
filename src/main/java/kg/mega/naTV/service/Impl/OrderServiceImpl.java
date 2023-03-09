package kg.mega.naTV.service.Impl;

import kg.mega.naTV.entities.Discounts;
import kg.mega.naTV.entities.Price;
import kg.mega.naTV.entities.dto.request.GetOrderDto;
import kg.mega.naTV.entities.dto.response.ChannelForOrderDto;
import kg.mega.naTV.entities.dto.response.SaveOrderDto;
import kg.mega.naTV.entities.enums.OrderStatus;
import kg.mega.naTV.mappers.OrderMapper;
import kg.mega.naTV.repository.DiscountRepo;
import kg.mega.naTV.repository.OrderRepo;
import kg.mega.naTV.repository.PriceRepo;
import kg.mega.naTV.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final OrderMapper orderMapper;
    private final PriceRepo priceRepo;
    private final DiscountRepo discountRepo;

    public SaveOrderDto createOrder(SaveOrderDto saveOrderDto) {
        saveOrderDto.setStatus(OrderStatus.CREATED);
        double sumPrice = 0;
        for (int i = 0; i < saveOrderDto.getChannels().size(); i++) {
            ChannelForOrderDto channel = saveOrderDto.getChannels().get(i);
            long spaces = saveOrderDto.getText().chars().filter(c -> c == ' ').count();
            Long countOfSymbols = saveOrderDto.getText().length() - spaces;
            Price price = priceRepo.findByChannelsId(channel.getChannelId());
            Double priceWithoutDiscount = priceWithoutDiscount(price, countOfSymbols, channel.getDays().size());
            channel.setPrice(priceWithoutDiscount);
            List<Discounts> discountsList = discountRepo.findAllByChannelId(channel.getChannelId());
            if (discountsList.size() == 0) {
                channel.setPriceWithDiscount(priceWithoutDiscount);
            } else {
                Long percent = null;
                for (Discounts discounts : discountsList) {
                    if (channel.getDays().size() >= discounts.getFromDayCount()) {
                        percent = discounts.getDiscount();
                    }
                }
                Double priceWithDiscount = priceWithDiscount(priceWithoutDiscount, percent);
                channel.setPriceWithDiscount(priceWithDiscount);
            }
            sumPrice += Math.round(channel.getPriceWithDiscount());
        }
        saveOrderDto.setTotalPrice(sumPrice);
        return saveOrderDto;
    }

    private double priceWithDiscount(Double priceWithoutDiscount, Long percent) {
        return Math.round(priceWithoutDiscount - percent * 100 / priceWithoutDiscount);
    }

    private double priceWithoutDiscount(Price price, Long countOfSymbols, int days) {
        double symbolPrice = countOfSymbols * price.getPricePerLetter();
        return Math.round(days * symbolPrice);
    }

    @Override
    public GetOrderDto saveOrder(GetOrderDto getOrderDto) {
        return null;
    }
}
