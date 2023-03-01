package kg.mega.naTV.service;

import kg.mega.naTV.entities.Channels;
import kg.mega.naTV.entities.dto.ChannelsDto;

public interface ChannelService {
    Channels registration(ChannelsDto channelsDto) throws Exception;


}
