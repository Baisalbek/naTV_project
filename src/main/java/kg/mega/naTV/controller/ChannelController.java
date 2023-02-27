package kg.mega.naTV.controller;

import kg.mega.naTV.entities.Channels;
import kg.mega.naTV.entities.dto.ChannelsDto;
import kg.mega.naTV.service.Impl.ChannelServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CHANNEL")
public class ChannelController {
    private final ChannelServiceImpl channelServiceImpl;
    public ChannelController(ChannelServiceImpl channelServiceImpl) {
        this.channelServiceImpl = channelServiceImpl;
    }

    @PostMapping("/save")
    public ResponseEntity saveChannel(@RequestBody Channels channels) {
        try {
            channelServiceImpl.registration(channels);
            return ResponseEntity.ok().body("Название канала успешно сохранен!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/LIST")
    public List<ChannelsDto> channelsDtoList() {
        return channelServiceImpl.getChannelList();
    }
}
