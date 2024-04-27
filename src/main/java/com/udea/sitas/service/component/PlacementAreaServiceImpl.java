package com.udea.sitas.service.component;

import com.udea.sitas.persistence.component.PlacementAreaPersistence;
import com.udea.sitas.persistence.dto.PlacementAreaDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlacementAreaServiceImpl implements PlacementAreaService{

    private static final String LOG_PREFIX = "Placement Area Service >>";

    private final PlacementAreaPersistence placementAreaPersistence;

    @Override
    public List<PlacementAreaDto> findAll() {
        log.info("{} Find all placement areas", LOG_PREFIX);
        return placementAreaPersistence.findAll();
    }

    @Override
    public PlacementAreaDto findById(Long id) {
        log.info("{} Find placement area with ID {}", LOG_PREFIX, id);
        return placementAreaPersistence.findById(id);
    }

    @Override
    public void placementAreaExist(Long id) {
        log.info("{} Check if placement areas with ID {} exists", LOG_PREFIX, id);
        if (!placementAreaPersistence.placementAreaExist(id)) {
            throw new NoSuchElementException("Placement area does not exist");
        }
    }
}
