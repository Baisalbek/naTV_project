package kg.mega.naTV.controller;

import kg.mega.naTV.entities.dto.ChannelDto;
import kg.mega.naTV.entities.dto.response.ChannelCalcDto;
import kg.mega.naTV.entities.dto.response.ChannelGetListDto;
import kg.mega.naTV.mappers.ChannelMapper;
import kg.mega.naTV.service.Impl.ChannelServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/CHANNEL")
public class ChannelController {
    private final ChannelServiceImpl channelServiceImpl;
    private final ChannelMapper channelMapper;

    public ChannelController(ChannelServiceImpl channelServiceImpl, ChannelMapper channelMapper) {
        this.channelServiceImpl = channelServiceImpl;
        this.channelMapper = channelMapper;
    }

    @PostMapping("/save")
    public ResponseEntity saveChannel(@RequestBody ChannelDto channelDto) {
        try {
            channelServiceImpl.registration(channelDto);
            return ResponseEntity.ok().body("Название канала успешно сохранен!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/LIST")
    public List<ChannelGetListDto> channelsDtoList() {
        return channelServiceImpl.getChannelList();
    }

    @GetMapping("/calculate")
    public ChannelCalcDto calculatePrice(@RequestBody ChannelCalcDto  channelCalcDto){
        return channelServiceImpl.calcDto(channelCalcDto);
    }


}
