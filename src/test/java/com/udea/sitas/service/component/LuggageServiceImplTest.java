package com.udea.sitas.service.component;

import com.udea.sitas.persistence.component.LuggagePersistence;
import com.udea.sitas.persistence.dto.LuggageDto;
import com.udea.sitas.persistence.dto.PlacementAreaDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class LuggageServiceImplTest {

    @InjectMocks
    private LuggageServiceImpl luggageService;

    @Mock
    private LuggagePersistence luggagePersistence;
    @Mock
    private PlacementAreaService placementAreaService;

    @Test
    public void GivenLuggageWithPlacementArea_WhenCreate_ShouldReturnWithId() {

        PlacementAreaDto placementAreaTest = PlacementAreaDto.builder()
                .id(1L)
                .name("Area test")
                .build();

        LuggageDto luggageDtoToSave = LuggageDto.builder()
                .bookingId(1L)
                .description("Test Luggage")
                .extraCharge(10.0)
                .type("Test")
                .flightId(1L)
                .height(10.0)
                .width(10.0)
                .weight(10.0)
                .length(10.0)
                .userId(1L)
                .quantity(1)
                .placementArea(placementAreaTest)
                .build();

        LuggageDto luggageDtoSaved = luggageDtoToSave;
        luggageDtoSaved.setId(1L);

        Mockito.when(luggagePersistence.save(luggageDtoToSave))
                .thenReturn(luggageDtoSaved);

        final LuggageDto luggageDtoResponse = luggageService.create(luggageDtoToSave);

        Mockito.verify(placementAreaService)
                .placementAreaExist(1L);

        Mockito.verify(luggagePersistence)
                .save(luggageDtoToSave);

        Assertions.assertThat(luggageDtoResponse)
                .hasFieldOrPropertyWithValue("id", 1L);
    }}
