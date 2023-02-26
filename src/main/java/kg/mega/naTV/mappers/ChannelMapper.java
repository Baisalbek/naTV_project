package kg.mega.naTV.mappers;

import kg.mega.naTV.entities.Channels;
import kg.mega.naTV.entities.dto.ChannelsDto;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ChannelMapper {
    public ChannelsDto toDto(Channels channels);
    public Channels toEntity(ChannelsDto channelDto);

    public List<ChannelsDto> ListToDto(List<Channels> channelList);
    public List<Channels> ListToEntity(List<ChannelsDto> channelDtoList);

}
