package com.udea.sitas.service.component;

import com.udea.sitas.persistence.dto.LuggageDto;

public interface PlacementAreaMeasurements {

    Long getPlacementAreaType();
    void checkMeasurements(LuggageDto luggageDto);
}
