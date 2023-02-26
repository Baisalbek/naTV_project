package kg.mega.naTV.controller;

import kg.mega.naTV.entities.Channels;
import kg.mega.naTV.service.Impl.ChannelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/channels")
public class ChannelsController {

    @Autowired
    private ChannelServiceImpl channelServiceImpl;

    @PostMapping("/save")
    public ResponseEntity saveChannel(@RequestBody Channels channels) {
        try {
            channelServiceImpl.registration(channels);
            return ResponseEntity.ok().body("Название канала успешно сохранен!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
