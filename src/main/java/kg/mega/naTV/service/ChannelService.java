package kg.mega.naTV.service;

import kg.mega.naTV.entities.Channels;
import kg.mega.naTV.entities.dto.ChannelDto;
import kg.mega.naTV.entities.dto.response.ChannelCalcDto;
import kg.mega.naTV.entities.dto.response.ChannelGetListDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ChannelService {
    Channels registration(ChannelDto channelDto, MultipartFile logo) throws Exception;
    List<ChannelGetListDto> getChannelList();
    ChannelCalcDto calcDto(ChannelCalcDto channelCalcDto);
}
