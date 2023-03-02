package kg.mega.naTV.service.Impl;

import kg.mega.naTV.entities.TextAd;
import kg.mega.naTV.entities.dto.TextAdDto;
import kg.mega.naTV.mappers.TextAdMapper;
import kg.mega.naTV.repository.TextAdRepo;
import kg.mega.naTV.service.TextAdService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TextAdServiceImpl implements TextAdService {
    private final TextAdRepo textAdRepo;
    private final TextAdMapper textAdMapper;

    public TextAdServiceImpl(TextAdRepo textAdRepo, TextAdMapper textAdMapper) {
        this.textAdRepo = textAdRepo;
        this.textAdMapper = textAdMapper;
    }

    public ResponseEntity<?> inputText(TextAdDto textAdDto) {
        TextAd textAd = textAdMapper.toEntity(textAdDto);
        Long spaces = textAd.getText().chars().filter(c -> c == ' ').count();
        textAd.setCountOfSymbols(textAd.getText().length() - spaces);
        return ResponseEntity.ok(textAdRepo.save(textAd));
    }

    @Override
    public TextAd getText(Long id) {
        return textAdRepo.findById(id).get();
    }
}
