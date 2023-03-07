package kg.mega.naTV.service;

import kg.mega.naTV.entities.Channels;
import kg.mega.naTV.entities.dto.ChannelDto;
import kg.mega.naTV.entities.dto.response.ChannelGetListDto;

public interface ChannelService {
    Channels registration(ChannelDto channelDto) throws Exception;


}
