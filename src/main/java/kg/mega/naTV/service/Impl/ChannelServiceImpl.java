package kg.mega.naTV.service.Impl;

import kg.mega.naTV.entities.Channels;
import kg.mega.naTV.repository.ChannelRepo;
import kg.mega.naTV.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private ChannelRepo channelRepo;

//    public Channels registration(Channels channels) throws Exception {
//        if (channelRepo.findByNameOfChannel(channels.getNameOfChannel()) != null) {
//            throw new Exception ("Канал с таким названием уже существует!");
//        }
//        return channelRepo.save(channels);
//    }
}
