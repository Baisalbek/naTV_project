package kg.mega.naTV.mappers;

import kg.mega.naTV.entities.OrderedChannels;
import kg.mega.naTV.entities.dto.response.OrderedChannelsDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OrderedChannelsMapper {
    OrderedChannelsDto toDto(OrderedChannels orderedChannels);

    OrderedChannels toEntity(OrderedChannelsDto orderedChannelsDto);

    List<OrderedChannelsDto> ListToDto(List<OrderedChannels> orderedChannelsList);

    List<OrderedChannels> ListToEntity(List<OrderedChannelsDto> orderedChannelsDtoList);
}

