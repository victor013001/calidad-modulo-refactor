package com.udea.sitas.service.component;

import com.udea.sitas.persistence.component.LuggagePersistence;
import com.udea.sitas.persistence.dto.LuggageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class LuggageServiceImpl implements LuggageService{

    private static final String LOG_PREFIX = "Luggage Service >>";

    private final LuggagePersistence luggagePersistence;
    private final PlacementAreaService placementAreaService;

    @Override
    public LuggageDto create(LuggageDto luggageDto) {
        checkPlacementAreaExist(luggageDto.getPlacementArea().getId());
        log.info("{} Save new luggage for user {}", LOG_PREFIX, luggageDto.getUserId());
        return luggagePersistence.save(luggageDto);
    }

    @Override
    public List<LuggageDto> findAll() {
        log.info("{} Find all luggage's", LOG_PREFIX);
        return luggagePersistence.findAll();
    }

    @Override
    public LuggageDto findById(Long id) {
        log.info("{} Find luggage with ID {}", LOG_PREFIX, id);
        return luggagePersistence.findById(id);
    }

    @Override
    public void delete(Long id) {
        checkLuggageExist(id);
        log.info("{} Delete luggage with ID {}", LOG_PREFIX, id);
        luggagePersistence.delete(id);
    }

    @Override
    public LuggageDto update(LuggageDto luggageDto, Long id) {
        checkLuggageExist(id);
        checkPlacementAreaExist(luggageDto.getPlacementArea().getId());
        luggageDto.setId(id);
        log.info("{} Update luggage with ID {}, for user {}", LOG_PREFIX, id, luggageDto.getUserId());
        return luggagePersistence.save(luggageDto);
    }

    @Override
    public List<LuggageDto> findByPlacementAreaId(Long id) {
        checkPlacementAreaExist(id);
        log.info("{} Find luggage with placement area ID {}", LOG_PREFIX, id);
        return luggagePersistence.findAllByPlacementAreaId(id);
    }

    private void checkLuggageExist(Long id) {
        log.info("{} Check if luggage with ID {} exists", LOG_PREFIX, id);
        if (!luggagePersistence.luggageExist(id)) {
            throw new NoSuchElementException("Luggage does not exist");
        }
    }

    private void checkPlacementAreaExist(Long id) {
        placementAreaService.placementAreaExist(id);
    }
}
