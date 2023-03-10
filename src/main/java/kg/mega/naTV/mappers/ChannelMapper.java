package kg.mega.naTV.mappers;

import kg.mega.naTV.entities.Channels;
import kg.mega.naTV.entities.dto.ChannelDto;
import kg.mega.naTV.entities.dto.response.ChannelForOrderDto;
import kg.mega.naTV.entities.dto.response.ChannelGetListDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ChannelMapper {
    public ChannelGetListDto toDto(Channels channels);
    public Channels toEntity(ChannelDto channelDto);

    public List<ChannelGetListDto> ListToDto(List<Channels> channelList);
    public List<Channels> ListToEntity(List<ChannelGetListDto> channelDtoList);
    @Mapping(source = "channelId", target = "id")
    public Channels channelToEntity(ChannelForOrderDto channelForOrderDto);


}
