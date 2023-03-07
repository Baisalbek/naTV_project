package kg.mega.naTV.mappers;

import kg.mega.naTV.entities.Channels;
import kg.mega.naTV.entities.dto.ChannelDto;
import kg.mega.naTV.entities.dto.response.ChannelGetListDto;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ChannelMapper {
    public ChannelGetListDto toDto(Channels channels);
    public Channels toEntity(ChannelDto channelDto);

    public List<ChannelGetListDto> ListToDto(List<Channels> channelList);
    public List<Channels> ListToEntity(List<ChannelGetListDto> channelDtoList);

}
