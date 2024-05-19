package com.udea.sitas.service.component;

import com.udea.sitas.persistence.dto.LuggageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PlacementArea3MeasurementsImpl implements PlacementAreaMeasurements{

    private static final String LOG_PREFIX = "Placement area id 3 measurements Service >>";
    private static final double MAX_HEIGHT_AREA = 55;
    private static final double MAX_LENGTH_AREA = 35;
    private static final double MAX_WIDTH_AREA = 25;

    @Override
    public Long getPlacementAreaType() {
        return 3L;
    }

    @Override
    public void checkMeasurements(LuggageDto luggageDto) {
        log.info("{} Checking luggage measurements", LOG_PREFIX);
        if (!(luggageDto.getHeight() <= MAX_HEIGHT_AREA
                && luggageDto.getLength() <= MAX_LENGTH_AREA
                && luggageDto.getWidth() <= MAX_WIDTH_AREA)) {
            throw new IllegalArgumentException("Invalid measurements, the valid measurements are: " + getMeasurements());
        }
    }

    private String getMeasurements() {
        return "Alto: " + MAX_HEIGHT_AREA + " cm, Largo: " + MAX_LENGTH_AREA + " cm, Ancho: " + MAX_WIDTH_AREA
                + " cm";

    }

}
