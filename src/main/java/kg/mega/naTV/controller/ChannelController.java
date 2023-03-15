package kg.mega.naTV.controller;

import io.swagger.annotations.ApiOperation;
import kg.mega.naTV.entities.dto.ChannelDto;
import kg.mega.naTV.entities.dto.response.ChannelCalcDto;
import kg.mega.naTV.entities.dto.response.ChannelGetListDto;
import kg.mega.naTV.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/channels")
public class ChannelController {
    private final ChannelService channelService;

    @ApiOperation("Сохранение канала.")
    @PostMapping("/save")
    public ResponseEntity<?> saveChannel(@ModelAttribute ChannelDto channelDto,@RequestPart(required = false) MultipartFile file) {
        try {
            channelService.registration(channelDto, file);
            return ResponseEntity.ok().body("Название канала успешно сохранен!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ApiOperation("Получение списка каналов.")
    @GetMapping("/list")
    public List<ChannelGetListDto> channelsDtoList() {
        return channelService.getChannelList();
    }

    @ApiOperation("Получение стоимости рекламы на одном канале.")
    @GetMapping("/calculate")
    public ChannelCalcDto calculatePrice(@RequestBody ChannelCalcDto channelCalcDto) {
        return channelService.calcDto(channelCalcDto);
    }
}
