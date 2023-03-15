package kg.mega.naTV.mappers;

import kg.mega.naTV.entities.Channels;
import kg.mega.naTV.entities.dto.ChannelDto;
import kg.mega.naTV.entities.dto.response.OrderedChannelsDto;
import kg.mega.naTV.entities.dto.response.ChannelGetListDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ChannelMapper {

   ChannelGetListDto toDto(Channels channels);

    Channels toEntity(ChannelGetListDto channelGetListDto);

    Channels DtoToEntity(ChannelDto channelDto);

    ChannelDto EntityTtoDto(Channels channels);

    List<ChannelGetListDto> ListToDto(List<Channels> channelList);

    List<Channels> ListToEntity(List<ChannelGetListDto> channelDtoList);

    @Mapping(source = "channelId", target = "id")
    Channels channelToEntity(OrderedChannelsDto orderedChannelsDto);
}
