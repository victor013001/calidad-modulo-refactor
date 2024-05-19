package com.udea.sitas.service.component;

import com.udea.sitas.persistence.dto.LuggageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlacementAreaMeasurementsService {

    private final List<PlacementAreaMeasurements> placementAreaMeasurements;

    public void checkMeasurements(LuggageDto luggageDto, Long placementAreaId) {
        getImplementation(placementAreaId).checkMeasurements(luggageDto);
    }

    private PlacementAreaMeasurements getImplementation(Long placementAreaId) {
        return placementAreaMeasurements.stream()
                .filter(service -> placementAreaId.equals(service.getPlacementAreaType()))
                .findFirst()
                .orElseThrow();
    }
}

